import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalPropertyPage } from './rental-property.page';

describe('RentalPropertyPage', () => {
  let component: RentalPropertyPage;
  let fixture: ComponentFixture<RentalPropertyPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RentalPropertyPage]
    }).compileComponents();

    fixture = TestBed.createComponent(RentalPropertyPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
