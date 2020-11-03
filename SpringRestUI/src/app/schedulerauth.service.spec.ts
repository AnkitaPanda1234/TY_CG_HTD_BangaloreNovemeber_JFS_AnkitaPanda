import { TestBed } from '@angular/core/testing';

import { SchedulerauthService } from './schedulerauth.service';

describe('SchedulerauthService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SchedulerauthService = TestBed.get(SchedulerauthService);
    expect(service).toBeTruthy();
  });
});
