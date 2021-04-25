import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferRentalComponent } from './offer-rental.component';

describe('OfferRentalComponent', () => {
  let component: OfferRentalComponent;
  let fixture: ComponentFixture<OfferRentalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OfferRentalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferRentalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
