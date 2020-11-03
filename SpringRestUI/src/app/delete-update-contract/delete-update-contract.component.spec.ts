import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUpdateContractComponent } from './delete-update-contract.component';

describe('DeleteUpdateContractComponent', () => {
  let component: DeleteUpdateContractComponent;
  let fixture: ComponentFixture<DeleteUpdateContractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUpdateContractComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUpdateContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
