import { Routes } from '@angular/router';
import { HomePage } from './pages/home/home.page';
import { PropertyPage } from './pages/property/property.page';
import { ContactPage } from './pages/contact/contact.page';
import { FaqPage } from './pages/faq/faq.page';

export const routes: Routes = [
  {
    path: '',
    component: HomePage,
    title: 'Home page'
  },
  // {
  //   path: 'about',
  //   component: AboutPage,
  //   title: 'Sign in'
  // },
  // {
  //   path: 'dashboard/profile',
  //   component: AccountPage,
  //   title: 'Mon profile'
  // },
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
  }
  // {
  //   path: 'dashboard/reservations',
  //   component: ReservationsPage,
  //   title: 'Reservations'
  // },
  // {
  //   path: 'sign-in',
  //   component: SignInPage,
  //   title: 'Sign in'
  // },
  // {
  //   path: 'sign-up',
  //   component: SignUpPage,
  //   title: 'Sign up'
  // }
];
