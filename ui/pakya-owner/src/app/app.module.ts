import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CheckRentalRequestComponent } from './check-rental-request/check-rental-request.component';
import { OfferRentalComponent } from './offer-rental/offer-rental.component';

@NgModule({
  declarations: [
    AppComponent,
    CheckRentalRequestComponent,
    OfferRentalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
