import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteUpdateProductComponent } from './delete-update-product.component';

describe('DeleteUpdateProductComponent', () => {
  let component: DeleteUpdateProductComponent;
  let fixture: ComponentFixture<DeleteUpdateProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteUpdateProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteUpdateProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
