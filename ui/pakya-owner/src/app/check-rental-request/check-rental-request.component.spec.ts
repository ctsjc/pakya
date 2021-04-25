import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckRentalRequestComponent } from './check-rental-request.component';

describe('CheckRentalRequestComponent', () => {
  let component: CheckRentalRequestComponent;
  let fixture: ComponentFixture<CheckRentalRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckRentalRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckRentalRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
