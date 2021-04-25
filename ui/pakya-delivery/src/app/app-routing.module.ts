import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckDeliveryRequestComponent } from './check-delivery-request/check-delivery-request.component';
import { OfferDeliveryComponent } from './offer-delivery/offer-delivery.component';

const routes: Routes = [{
  path: 'check-delivery-request', component: CheckDeliveryRequestComponent
}, {
  path: 'offer-delivery', component: OfferDeliveryComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
