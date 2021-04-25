import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CheckDeliveryRequestComponent } from './check-delivery-request/check-delivery-request.component';
import { OfferDeliveryComponent } from './offer-delivery/offer-delivery.component';

@NgModule({
  declarations: [
    AppComponent,
    CheckDeliveryRequestComponent,
    OfferDeliveryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
