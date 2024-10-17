import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule, NgbProgressbarModule } from '@ng-bootstrap/ng-bootstrap';
import { CustomProgressBarComponent } from './components/custom-progress-bar/custom-progress-bar.component';
import { CustomProgressBar2Component } from './components/custom-progress-bar-2/custom-progress-bar-2.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomProgressBarComponent,
    CustomProgressBar2Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    NgbProgressbarModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
