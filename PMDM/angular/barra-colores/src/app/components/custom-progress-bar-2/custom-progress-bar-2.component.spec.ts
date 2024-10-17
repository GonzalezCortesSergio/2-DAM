import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomProgressBar2Component } from './custom-progress-bar-2.component';

describe('CustomProgressBar2Component', () => {
  let component: CustomProgressBar2Component;
  let fixture: ComponentFixture<CustomProgressBar2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CustomProgressBar2Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomProgressBar2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
