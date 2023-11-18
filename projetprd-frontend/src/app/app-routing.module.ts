import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './components/signup/signup.component';
import { WelcomePageComponent } from './components/welcome-page/welcome-page.component';
import { FormulaireComponent } from './components/formulaire/formulaire.component';
import { PreviewComponent } from './components/preview/preview.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'Signup', component: SignupComponent },
  { path: 'login', component: WelcomePageComponent },
  { path: 'Formulaire', component: FormulaireComponent },
  { path: 'preview/:id', component: PreviewComponent },
  { path: '**', component: WelcomePageComponent },



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
