import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TestSharedModule } from 'app/shared/shared.module';
import { AuctionComponent } from './auction.component';
import { AuctionDetailComponent } from './auction-detail.component';
import { AuctionUpdateComponent } from './auction-update.component';
import { AuctionDeleteDialogComponent } from './auction-delete-dialog.component';
import { auctionRoute } from './auction.route';

@NgModule({
  imports: [TestSharedModule, RouterModule.forChild(auctionRoute)],
  declarations: [AuctionComponent, AuctionDetailComponent, AuctionUpdateComponent, AuctionDeleteDialogComponent],
  entryComponents: [AuctionDeleteDialogComponent],
})
export class TestAuctionModule {}
