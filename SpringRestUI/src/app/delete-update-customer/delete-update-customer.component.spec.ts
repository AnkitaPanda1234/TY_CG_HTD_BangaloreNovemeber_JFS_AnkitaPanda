import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUpdateCustomerComponent } from './delete-update-customer.component';

describe('DeleteUpdateCustomerComponent', () => {
  let component: DeleteUpdateCustomerComponent;
  let fixture: ComponentFixture<DeleteUpdateCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUpdateCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUpdateCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
