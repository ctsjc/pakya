import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckDeliveryRequestComponent } from './check-delivery-request.component';

describe('CheckDeliveryRequestComponent', () => {
  let component: CheckDeliveryRequestComponent;
  let fixture: ComponentFixture<CheckDeliveryRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckDeliveryRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckDeliveryRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
