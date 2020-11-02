import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { TestTestModule } from '../../../test.module';
import { ExclusiveContentDetailComponent } from 'app/entities/exclusive-content/exclusive-content-detail.component';
import { ExclusiveContent } from 'app/shared/model/exclusive-content.model';

describe('Component Tests', () => {
  describe('ExclusiveContent Management Detail Component', () => {
    let comp: ExclusiveContentDetailComponent;
    let fixture: ComponentFixture<ExclusiveContentDetailComponent>;
    const route = ({ data: of({ exclusiveContent: new ExclusiveContent(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TestTestModule],
        declarations: [ExclusiveContentDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(ExclusiveContentDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ExclusiveContentDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load exclusiveContent on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.exclusiveContent).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
