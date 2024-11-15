import { Routes } from '@angular/router';
import { ClientesComponent } from './clientes/clientes.component';
import { ReportesComponent } from './reportes/reportes.component';

export const routes: Routes = [
  {
    path: 'reportes',
    component: ReportesComponent,
  },
  {
    path: 'clientes',
    component: ClientesComponent,
  },
];
