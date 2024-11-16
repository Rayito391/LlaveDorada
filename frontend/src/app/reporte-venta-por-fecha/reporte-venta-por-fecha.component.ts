import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {
  MatDatepicker,
  MatDatepickerInput,
  MatDatepickerModule,
  MatDatepickerToggle
} from "@angular/material/datepicker";
import {MatFormField, MatFormFieldModule, MatHint, MatLabel, MatSuffix} from "@angular/material/form-field";
import {MatInput, MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatSelectModule} from "@angular/material/select";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {provideNativeDateAdapter} from "@angular/material/core";
import {CurrencyPipe, DatePipe, NgForOf} from "@angular/common";
import {Venta} from "../types";

@Component({
  selector: 'app-reporte-venta-por-fecha',
  templateUrl: './reporte-venta-por-fecha.component.html',
  standalone: true,
  providers: [provideNativeDateAdapter(), DatePipe],
  imports: [
    MatInputModule,
    MatFormFieldModule, MatButtonModule, MatDatepickerModule, ReactiveFormsModule, MatSelectModule, HttpClientModule, FormsModule, CurrencyPipe, DatePipe, NgForOf
  ],
  styleUrls: ['./reporte-venta-por-fecha.component.css']
})
export class ReporteVentaPorFechaComponent implements OnInit {
  form: FormGroup
  ventas: Venta[] = [];

  constructor(private datePipe: DatePipe, private http: HttpClient) {
    this.form = new FormGroup({
      fecha: new FormControl('', Validators.required),
    });
  }

  ngOnInit() {
    this.form.get('fecha')?.valueChanges.subscribe((fecha) => {
      if (fecha) {
        this.obtenerVentasPorFecha(fecha);
      }
    });
  }

  obtenerVentasPorFecha(date: Date) {
    const fecha = this.datePipe.transform(date, 'yyyy-MM-dd')!
    this.http.get<Venta[]>(`http://localhost:8080/reportes/ventas/fecha/${fecha}`).subscribe((ventas: any) => {
      this.ventas = ventas;
    });
  }
}
