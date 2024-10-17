import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TablaComponent } from './components/tabla/tabla.component';
import { PhonePrefixListComponent } from './components/phone-prefix-list/phone-prefix-list.component';

@NgModule({
  declarations: [
    AppComponent,
    TablaComponent,
    PhonePrefixListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
