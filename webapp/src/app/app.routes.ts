import { Routes } from '@angular/router';
import { SignInPage } from './pages/sign-in/sign-in.page';
import { SignUpPage } from './pages/sign-up/sign-up.page';
import { AboutPage } from './pages/about/about.page';
import { AccountPage } from './pages/account/account.page';
import { ContactPage } from './pages/contact/contact.page';
import { FaqPage } from './pages/faq/faq.page';
import { RentalPropertiesPage } from './pages/rental-properties/rental-properties.page';
import { RentalPropertyPage } from './pages/rental-property/rental-property.page';
import { ReservationsPage } from './pages/reservations/reservations.page';

export const routes: Routes = [
  {
    path: '',
    component: RentalPropertiesPage,
    title: 'Home page'
  },
  {
    path: 'about',
    component: AboutPage,
    title: 'Sign in'
  },
  {
    path: 'dashboard/profile',
    component: AccountPage,
    title: 'Mon profile'
  },
  {
    path: 'contact',
    component: ContactPage,
    title: 'Contact'
  },
  {
    path: 'faq',
    component: FaqPage,
    title: 'FAQ'
  },
  {
    path: 'property/:id',
    component: RentalPropertyPage,
    title: 'Sign in'
  },
  {
    path: 'reservations',
    component: ReservationsPage,
    title: 'Reservations'
  },
  {
    path: 'sign-in',
    component: SignInPage,
    title: 'Sign in'
  },
  {
    path: 'sign-up',
    component: SignUpPage,
    title: 'Sign up'
  }
];
