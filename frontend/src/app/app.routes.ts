import { Routes } from '@angular/router';
import { ClientesComponent } from './clientes/clientes.component';
import { ReportesComponent } from './reportes/reportes.component';
import {UsuariosComponent} from "./usuarios/usuarios.component";
import {ProductosComponent} from "./productos/productos.component";

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
  },
  {
    path: 'productos',
    component: ProductosComponent
  }
];
