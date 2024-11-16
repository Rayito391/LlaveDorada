import { HttpClient } from '@angular/common/http';
import { Component, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
  FormsModule,
} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { ReporteVentaClienteComponent } from '../reporte-venta-cliente/reporte-venta-cliente.component';
import { ReporteDetalleVentaComponent } from '../reporte-detalle-venta/reporte-detalle-venta.component';
import {ReporteVentaPorFechaComponent} from "../reporte-venta-por-fecha/reporte-venta-por-fecha.component";
import {ReporteVentaPorPeriodoComponent} from "../reporte-venta-por-periodo/reporte-venta-por-periodo.component";
import {
  ReporteVentaPorTipoClienteComponent
} from "../reporte-venta-por-tipo-cliente/reporte-venta-por-tipo-cliente.component";

@Component({
  standalone: true,
  imports: [
    CommonModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatSelectModule,
    HttpClientModule,
    MatRadioModule,
    ReporteVentaClienteComponent,
    FormsModule,
    ReporteDetalleVentaComponent,
    ReporteVentaPorFechaComponent,
    ReporteVentaPorPeriodoComponent,
    ReporteVentaPorTipoClienteComponent,
  ],
  selector: 'app-reportes-form',
  templateUrl: './reportes-form.component.html',
  styleUrls: ['./reportes-form.component.css'],
})
export class ReportesFormComponent implements OnChanges {
  selectedOption: number = 1;

  constructor(private http: HttpClient) {
  }

  ngOnChanges(changes: SimpleChanges): void {}
}
