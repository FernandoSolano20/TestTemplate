import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TestSharedModule } from 'app/shared/shared.module';
import { UserPreferencesComponent } from './user-preferences.component';
import { UserPreferencesDetailComponent } from './user-preferences-detail.component';
import { UserPreferencesUpdateComponent } from './user-preferences-update.component';
import { UserPreferencesDeleteDialogComponent } from './user-preferences-delete-dialog.component';
import { userPreferencesRoute } from './user-preferences.route';

@NgModule({
  imports: [TestSharedModule, RouterModule.forChild(userPreferencesRoute)],
  declarations: [
    UserPreferencesComponent,
    UserPreferencesDetailComponent,
    UserPreferencesUpdateComponent,
    UserPreferencesDeleteDialogComponent,
  ],
  entryComponents: [UserPreferencesDeleteDialogComponent],
})
export class TestUserPreferencesModule {}
