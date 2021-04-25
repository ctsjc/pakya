import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferDeliveryComponent } from './offer-delivery.component';

describe('OfferDeliveryComponent', () => {
  let component: OfferDeliveryComponent;
  let fixture: ComponentFixture<OfferDeliveryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OfferDeliveryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferDeliveryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
