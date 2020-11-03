import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUpdateLandComponent } from './delete-update-land.component';

describe('DeleteUpdateLandComponent', () => {
  let component: DeleteUpdateLandComponent;
  let fixture: ComponentFixture<DeleteUpdateLandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUpdateLandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUpdateLandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
