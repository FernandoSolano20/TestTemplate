import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TestSharedModule } from 'app/shared/shared.module';
import { AdminPreferencesComponent } from './admin-preferences.component';
import { AdminPreferencesDetailComponent } from './admin-preferences-detail.component';
import { AdminPreferencesUpdateComponent } from './admin-preferences-update.component';
import { AdminPreferencesDeleteDialogComponent } from './admin-preferences-delete-dialog.component';
import { adminPreferencesRoute } from './admin-preferences.route';

@NgModule({
  imports: [TestSharedModule, RouterModule.forChild(adminPreferencesRoute)],
  declarations: [
    AdminPreferencesComponent,
    AdminPreferencesDetailComponent,
    AdminPreferencesUpdateComponent,
    AdminPreferencesDeleteDialogComponent,
  ],
  entryComponents: [AdminPreferencesDeleteDialogComponent],
})
export class TestAdminPreferencesModule {}
