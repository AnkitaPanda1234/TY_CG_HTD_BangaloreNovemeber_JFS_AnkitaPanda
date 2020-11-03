import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginschedulerComponent } from './loginscheduler.component';

describe('LoginschedulerComponent', () => {
  let component: LoginschedulerComponent;
  let fixture: ComponentFixture<LoginschedulerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginschedulerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginschedulerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
