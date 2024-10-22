import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { VehiclesListComponent } from './components/vehicles-list/vehicles-list.component';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { ModalVehcileComponent } from './components/modal-vehcile/modal-vehcile.component';
import { PeopleListComponent } from './components/people-list/people-list.component';
import { MenuComponent } from './shared/menu/menu.component';
import { ModalCharacterComponent } from './components/modal-character/modal-character.component';

@NgModule({
  declarations: [
    AppComponent,
    VehiclesListComponent,
    ModalVehcileComponent,
    PeopleListComponent,
    MenuComponent,
    ModalCharacterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
