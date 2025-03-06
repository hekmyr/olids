import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalPropertiesPage } from './rental-properties.page';

describe('RentalPropertiesPage', () => {
  let component: RentalPropertiesPage;
  let fixture: ComponentFixture<RentalPropertiesPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RentalPropertiesPage]
    }).compileComponents();

    fixture = TestBed.createComponent(RentalPropertiesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
