import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalPropertyAccessibilityAccordionComponent } from './rental-property-accessibility-accordion.component';

describe('RentalPropertyAccessibilityAccordionComponent', () => {
  let component: RentalPropertyAccessibilityAccordionComponent;
  let fixture: ComponentFixture<RentalPropertyAccessibilityAccordionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RentalPropertyAccessibilityAccordionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RentalPropertyAccessibilityAccordionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
