import { Routes } from '@angular/router';
import { ClientesComponent } from './clientes/clientes.component';
import { ReportesComponent } from './reportes/reportes.component';
import {UsuariosComponent} from "./usuarios/usuarios.component";

export const routes: Routes = [
  {
    path: 'reportes',
    component: ReportesComponent,
  },
  {
    path: 'clientes',
    component: ClientesComponent,
  },
  {
    path: 'usuarios',
    component: UsuariosComponent,
  }
];
