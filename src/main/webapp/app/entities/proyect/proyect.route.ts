import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IProyect, Proyect } from 'app/shared/model/proyect.model';
import { ProyectService } from './proyect.service';
import { ProyectComponent } from './proyect.component';
import { ProyectDetailComponent } from './proyect-detail.component';
import { ProyectUpdateComponent } from './proyect-update.component';

@Injectable({ providedIn: 'root' })
export class ProyectResolve implements Resolve<IProyect> {
  constructor(private service: ProyectService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IProyect> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((proyect: HttpResponse<Proyect>) => {
          if (proyect.body) {
            return of(proyect.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Proyect());
  }
}

export const proyectRoute: Routes = [
  {
    path: '',
    component: ProyectComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'testApp.proyect.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: ProyectDetailComponent,
    resolve: {
      proyect: ProyectResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'testApp.proyect.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: ProyectUpdateComponent,
    resolve: {
      proyect: ProyectResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'testApp.proyect.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: ProyectUpdateComponent,
    resolve: {
      proyect: ProyectResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'testApp.proyect.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
