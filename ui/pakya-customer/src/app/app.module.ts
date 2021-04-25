import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewRequestComponent } from './new-request/new-request.component';
import { CheckOfferComponent } from './check-offer/check-offer.component';
import { ReturnRequestComponent } from './return-request/return-request.component';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    NewRequestComponent,
    CheckOfferComponent,
    ReturnRequestComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
