import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckRentalRequestComponent } from './check-rental-request/check-rental-request.component';
import { OfferRentalComponent } from './offer-rental/offer-rental.component';

const routes: Routes = [{
  path: 'check-rental-request', component: CheckRentalRequestComponent
}, {
  path: 'offer-rental', component: OfferRentalComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
