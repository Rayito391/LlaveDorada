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
  ],
  selector: 'app-reportes-form',
  templateUrl: './reportes-form.component.html',
  styleUrls: ['./reportes-form.component.css'],
})
export class ReportesFormComponent implements OnChanges {
  form: FormGroup;
  selectedOption: number | null = null;

  constructor(private http: HttpClient) {
    this.form = new FormGroup({
      selectedOption: new FormControl(null, Validators.required),
    });
  }

  ngOnChanges(changes: SimpleChanges): void {}
}
