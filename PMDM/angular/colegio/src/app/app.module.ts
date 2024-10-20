import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { ListadoAlumnosComponent } from './components/listado-alumnos/listado-alumnos.component';
import { ListadoCursosComponent } from './components/listado-cursos/listado-cursos.component';
import { PantallaPrincipalComponent } from './components/pantalla-principal/pantalla-principal.component';

@NgModule({
  declarations: [
    AppComponent,
    ListadoAlumnosComponent,
    ListadoCursosComponent,
    PantallaPrincipalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch()),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
