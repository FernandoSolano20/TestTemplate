import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TestSharedModule } from 'app/shared/shared.module';
import { ReviewComponent } from './review.component';
import { ReviewDetailComponent } from './review-detail.component';
import { ReviewUpdateComponent } from './review-update.component';
import { ReviewDeleteDialogComponent } from './review-delete-dialog.component';
import { reviewRoute } from './review.route';

@NgModule({
  imports: [TestSharedModule, RouterModule.forChild(reviewRoute)],
  declarations: [ReviewComponent, ReviewDetailComponent, ReviewUpdateComponent, ReviewDeleteDialogComponent],
  entryComponents: [ReviewDeleteDialogComponent],
})
export class TestReviewModule {}
