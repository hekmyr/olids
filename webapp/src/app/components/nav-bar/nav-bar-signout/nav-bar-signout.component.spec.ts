import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavBarSignoutComponent } from './nav-bar-signout.component';

describe('NavBarSignoutComponent', () => {
  let component: NavBarSignoutComponent;
  let fixture: ComponentFixture<NavBarSignoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NavBarSignoutComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(NavBarSignoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
