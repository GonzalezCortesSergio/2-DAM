import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListadoAlumnosComponent } from './components/listado-alumnos/listado-alumnos.component';
import { ListadoCursosComponent } from './components/listado-cursos/listado-cursos.component';

const routes: Routes = [
  {path: 'alumnos', component: ListadoAlumnosComponent},
  {path: 'cursos', component: ListadoCursosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
