import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TestSharedModule } from 'app/shared/shared.module';
import { ExclusiveContentComponent } from './exclusive-content.component';
import { ExclusiveContentDetailComponent } from './exclusive-content-detail.component';
import { ExclusiveContentUpdateComponent } from './exclusive-content-update.component';
import { ExclusiveContentDeleteDialogComponent } from './exclusive-content-delete-dialog.component';
import { exclusiveContentRoute } from './exclusive-content.route';

@NgModule({
  imports: [TestSharedModule, RouterModule.forChild(exclusiveContentRoute)],
  declarations: [
    ExclusiveContentComponent,
    ExclusiveContentDetailComponent,
    ExclusiveContentUpdateComponent,
    ExclusiveContentDeleteDialogComponent,
  ],
  entryComponents: [ExclusiveContentDeleteDialogComponent],
})
export class TestExclusiveContentModule {}
