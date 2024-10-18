import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { provideHttpClient } from '@angular/common/http';
import { HouseListComponent } from './components/house-list/house-list.component';
import { NgxBootstrapIconsModule } from 'ngx-bootstrap-icons';

@NgModule({
  declarations: [
    AppComponent,
    HouseListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,

  ],
  providers: [
    provideClientHydration(),
    provideHttpClient()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
