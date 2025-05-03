import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; // Import routingu
import { AppComponent } from './app.component';
import { SignInComponent } from './auth/sign-in/sign-in.component'; // Komponent logowania
import { SignUpComponent } from './auth/sign-up/sign-up.component'; // Komponent rejestracji

@NgModule({
  declarations: [AppComponent, SignInComponent, SignUpComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
