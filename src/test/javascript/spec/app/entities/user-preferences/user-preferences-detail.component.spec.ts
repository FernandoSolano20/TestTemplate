import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { TestTestModule } from '../../../test.module';
import { UserPreferencesDetailComponent } from 'app/entities/user-preferences/user-preferences-detail.component';
import { UserPreferences } from 'app/shared/model/user-preferences.model';

describe('Component Tests', () => {
  describe('UserPreferences Management Detail Component', () => {
    let comp: UserPreferencesDetailComponent;
    let fixture: ComponentFixture<UserPreferencesDetailComponent>;
    const route = ({ data: of({ userPreferences: new UserPreferences(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TestTestModule],
        declarations: [UserPreferencesDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(UserPreferencesDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(UserPreferencesDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load userPreferences on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.userPreferences).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
