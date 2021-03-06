import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TestSharedModule } from 'app/shared/shared.module';
import { PartnerRequestComponent } from './partner-request.component';
import { PartnerRequestDetailComponent } from './partner-request-detail.component';
import { PartnerRequestUpdateComponent } from './partner-request-update.component';
import { PartnerRequestDeleteDialogComponent } from './partner-request-delete-dialog.component';
import { partnerRequestRoute } from './partner-request.route';

@NgModule({
  imports: [TestSharedModule, RouterModule.forChild(partnerRequestRoute)],
  declarations: [
    PartnerRequestComponent,
    PartnerRequestDetailComponent,
    PartnerRequestUpdateComponent,
    PartnerRequestDeleteDialogComponent,
  ],
  entryComponents: [PartnerRequestDeleteDialogComponent],
})
export class TestPartnerRequestModule {}
