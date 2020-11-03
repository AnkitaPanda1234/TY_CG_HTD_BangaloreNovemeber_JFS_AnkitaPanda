import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUpdateScheduleComponent } from './delete-update-schedule.component';

describe('DeleteUpdateScheduleComponent', () => {
  let component: DeleteUpdateScheduleComponent;
  let fixture: ComponentFixture<DeleteUpdateScheduleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUpdateScheduleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUpdateScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
