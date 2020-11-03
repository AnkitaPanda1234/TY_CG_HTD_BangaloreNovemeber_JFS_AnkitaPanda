import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulerAccountComponent } from './scheduler-account.component';

describe('SchedulerAccountComponent', () => {
  let component: SchedulerAccountComponent;
  let fixture: ComponentFixture<SchedulerAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchedulerAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedulerAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
