import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TestSharedModule } from 'app/shared/shared.module';
import { RecommendationComponent } from './recommendation.component';
import { RecommendationDetailComponent } from './recommendation-detail.component';
import { RecommendationUpdateComponent } from './recommendation-update.component';
import { RecommendationDeleteDialogComponent } from './recommendation-delete-dialog.component';
import { recommendationRoute } from './recommendation.route';

@NgModule({
  imports: [TestSharedModule, RouterModule.forChild(recommendationRoute)],
  declarations: [
    RecommendationComponent,
    RecommendationDetailComponent,
    RecommendationUpdateComponent,
    RecommendationDeleteDialogComponent,
  ],
  entryComponents: [RecommendationDeleteDialogComponent],
})
export class TestRecommendationModule {}
