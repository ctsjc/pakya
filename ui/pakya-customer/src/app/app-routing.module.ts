import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckOfferComponent } from './check-offer/check-offer.component';
import { NewRequestComponent } from './new-request/new-request.component';
import { ReturnRequestComponent } from './return-request/return-request.component';

const routes: Routes = [{
  path: 'new-request', component: NewRequestComponent
}, {
  path: 'check-offer', component: CheckOfferComponent
}, {
  path: 'raise-return', component: ReturnRequestComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
