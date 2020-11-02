import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'image',
        loadChildren: () => import('./image/image.module').then(m => m.TestImageModule),
      },
      {
        path: 'application-user',
        loadChildren: () => import('./application-user/application-user.module').then(m => m.TestApplicationUserModule),
      },
      {
        path: 'payment-method',
        loadChildren: () => import('./payment-method/payment-method.module').then(m => m.TestPaymentMethodModule),
      },
      {
        path: 'proyect',
        loadChildren: () => import('./proyect/proyect.module').then(m => m.TestProyectModule),
      },
      {
        path: 'proyect-account',
        loadChildren: () => import('./proyect-account/proyect-account.module').then(m => m.TestProyectAccountModule),
      },
      {
        path: 'category',
        loadChildren: () => import('./category/category.module').then(m => m.TestCategoryModule),
      },
      {
        path: 'checkpoint',
        loadChildren: () => import('./checkpoint/checkpoint.module').then(m => m.TestCheckpointModule),
      },
      {
        path: 'review',
        loadChildren: () => import('./review/review.module').then(m => m.TestReviewModule),
      },
      {
        path: 'donation-history',
        loadChildren: () => import('./donation-history/donation-history.module').then(m => m.TestDonationHistoryModule),
      },
      {
        path: 'auction',
        loadChildren: () => import('./auction/auction.module').then(m => m.TestAuctionModule),
      },
      {
        path: 'raffle',
        loadChildren: () => import('./raffle/raffle.module').then(m => m.TestRaffleModule),
      },
      {
        path: 'exclusive-content',
        loadChildren: () => import('./exclusive-content/exclusive-content.module').then(m => m.TestExclusiveContentModule),
      },
      {
        path: 'prize',
        loadChildren: () => import('./prize/prize.module').then(m => m.TestPrizeModule),
      },
      {
        path: 'partner-request',
        loadChildren: () => import('./partner-request/partner-request.module').then(m => m.TestPartnerRequestModule),
      },
      {
        path: 'notification',
        loadChildren: () => import('./notification/notification.module').then(m => m.TestNotificationModule),
      },
      {
        path: 'payment',
        loadChildren: () => import('./payment/payment.module').then(m => m.TestPaymentModule),
      },
      {
        path: 'user-preferences',
        loadChildren: () => import('./user-preferences/user-preferences.module').then(m => m.TestUserPreferencesModule),
      },
      {
        path: 'admin-preferences',
        loadChildren: () => import('./admin-preferences/admin-preferences.module').then(m => m.TestAdminPreferencesModule),
      },
      {
        path: 'fee',
        loadChildren: () => import('./fee/fee.module').then(m => m.TestFeeModule),
      },
      {
        path: 'app-log',
        loadChildren: () => import('./app-log/app-log.module').then(m => m.TestAppLogModule),
      },
      {
        path: 'recommendation',
        loadChildren: () => import('./recommendation/recommendation.module').then(m => m.TestRecommendationModule),
      },
      {
        path: 'password-history',
        loadChildren: () => import('./password-history/password-history.module').then(m => m.TestPasswordHistoryModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class TestEntityModule {}
