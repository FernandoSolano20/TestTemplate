import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IImage, Image } from 'app/shared/model/image.model';
import { ImageService } from './image.service';
import { IProyect } from 'app/shared/model/proyect.model';
import { ProyectService } from 'app/entities/proyect/proyect.service';
import { IPrize } from 'app/shared/model/prize.model';
import { PrizeService } from 'app/entities/prize/prize.service';

type SelectableEntity = IProyect | IPrize;

@Component({
  selector: 'jhi-image-update',
  templateUrl: './image-update.component.html',
})
export class ImageUpdateComponent implements OnInit {
  isSaving = false;
  proyects: IProyect[] = [];
  prizes: IPrize[] = [];

  editForm = this.fb.group({
    id: [],
    url: [null, [Validators.required]],
    proyect: [],
    prize: [],
  });

  constructor(
    protected imageService: ImageService,
    protected proyectService: ProyectService,
    protected prizeService: PrizeService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ image }) => {
      this.updateForm(image);

      this.proyectService.query().subscribe((res: HttpResponse<IProyect[]>) => (this.proyects = res.body || []));

      this.prizeService.query().subscribe((res: HttpResponse<IPrize[]>) => (this.prizes = res.body || []));
    });
  }

  updateForm(image: IImage): void {
    this.editForm.patchValue({
      id: image.id,
      url: image.url,
      proyect: image.proyect,
      prize: image.prize,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const image = this.createFromForm();
    if (image.id !== undefined) {
      this.subscribeToSaveResponse(this.imageService.update(image));
    } else {
      this.subscribeToSaveResponse(this.imageService.create(image));
    }
  }

  private createFromForm(): IImage {
    return {
      ...new Image(),
      id: this.editForm.get(['id'])!.value,
      url: this.editForm.get(['url'])!.value,
      proyect: this.editForm.get(['proyect'])!.value,
      prize: this.editForm.get(['prize'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IImage>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
