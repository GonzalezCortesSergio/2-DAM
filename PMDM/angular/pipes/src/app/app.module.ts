import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { DATE_PIPE_DEFAULT_OPTIONS } from '@angular/common';
import { KebabCasePipe } from './pipes/kebab-case.pipe';
import { CustomEurPipe } from './pipes/custom-eur.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    KebabCasePipe,
    CustomEurPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [
    provideClientHydration(),
    {
      provide: DATE_PIPE_DEFAULT_OPTIONS,
      useValue: {dateFormat: 'dd/MM/YYYY'}
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
