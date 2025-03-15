import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PropertyCollectionComponent } from './property-collection.component';

describe('PropertyCollectionComponent', () => {
  let component: PropertyCollectionComponent;
  let fixture: ComponentFixture<PropertyCollectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PropertyCollectionComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(PropertyCollectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
