import { TestBed } from '@angular/core/testing';

import { ReservationsServiceService } from './reservations-service.service';

describe('ReservationsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReservationsServiceService = TestBed.get(ReservationsServiceService);
    expect(service).toBeTruthy();
  });
});
