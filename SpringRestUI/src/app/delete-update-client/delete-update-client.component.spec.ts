import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUpdateClientComponent } from './delete-update-client.component';

describe('DeleteUpdateClientComponent', () => {
  let component: DeleteUpdateClientComponent;
  let fixture: ComponentFixture<DeleteUpdateClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUpdateClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUpdateClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
