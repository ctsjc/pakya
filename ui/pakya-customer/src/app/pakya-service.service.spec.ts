import { TestBed } from '@angular/core/testing';

import { PakyaServiceService } from './pakya-service.service';

describe('PakyaServiceService', () => {
  let service: PakyaServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PakyaServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
