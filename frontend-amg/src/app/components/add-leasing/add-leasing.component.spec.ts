import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLeasingComponent } from './add-leasing.component';

describe('AddLeasingComponent', () => {
  let component: AddLeasingComponent;
  let fixture: ComponentFixture<AddLeasingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddLeasingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddLeasingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
