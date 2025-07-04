import { Routes } from '@angular/router';
import { HomePage } from './pages/home/home.page';
import { PropertyPage } from './pages/property/property.page';
import { ContactPage } from './pages/contact/contact.page';
import { FaqPage } from './pages/faq/faq.page';
import { SignupSuccessPage } from './pages/signup-success/signup-success.page';
import { ReservationsPage } from './pages/reservations/reservations.page';
import { ProfilePage } from './pages/profile/profile.page';

export const routes: Routes = [
  {
    path: '',
    component: HomePage,
    title: 'Home page'
  },
  {
    path: 'profile',
    component: ProfilePage,
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
    component: PropertyPage,
    title: 'Property Details'
  },
  {
    path: 'signup-success',
    component: SignupSuccessPage,
    title: 'Sign Up Success'
  },
  {
    path: 'reservations',
    component: ReservationsPage,
    title: 'Reservations'
  }
];
