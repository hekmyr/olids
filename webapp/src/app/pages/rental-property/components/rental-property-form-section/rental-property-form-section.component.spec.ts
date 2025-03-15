import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalPropertyFormSectionComponent } from './rental-property-form-section.component';

describe('RentalPropertyFormSectionComponent', () => {
  let component: RentalPropertyFormSectionComponent;
  let fixture: ComponentFixture<RentalPropertyFormSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RentalPropertyFormSectionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RentalPropertyFormSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
