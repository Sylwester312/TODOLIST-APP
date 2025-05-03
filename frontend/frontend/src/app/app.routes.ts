import { Routes } from '@angular/router';
import { SignInComponent } from './auth/sign-in/sign-in.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { TaskListComponent } from '../../src/app/auth/tasks/task-detail';
import { TaskDetailComponent } from './tasks/task-detail/task-detail.component';
import { CategoryListComponent } from './categories/category-list/category-list.component';
import { CategoryDetailComponent } from './categories/category-detail/category-detail.component';

export const routes: Routes = [
  { path: '', redirectTo: 'sign-in', pathMatch: 'full' },
  { path: 'sign-in', component: SignInComponent },
  { path: 'sign-up', component: SignUpComponent },
  { path: 'tasks', component: TaskListComponent },
  { path: 'tasks/:id', component: TaskDetailComponent },
  { path: 'categories', component: CategoryListComponent },
  { path: 'categories/:id', component: CategoryDetailComponent },
  { path: '**', redirectTo: 'sign-in' },
];
