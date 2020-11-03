import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUpdateSchedulerComponent } from './delete-update-scheduler.component';

describe('DeleteUpdateSchedulerComponent', () => {
  let component: DeleteUpdateSchedulerComponent;
  let fixture: ComponentFixture<DeleteUpdateSchedulerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUpdateSchedulerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUpdateSchedulerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
