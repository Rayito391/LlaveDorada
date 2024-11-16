import { Component } from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {Venta} from "../types";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CurrencyPipe, DatePipe} from "@angular/common";

@Component({
  selector: 'app-reporte-venta-por-periodo',
  standalone: true,
  imports: [MatInputModule, ReactiveFormsModule, MatButton, HttpClientModule, DatePipe, CurrencyPipe],
  templateUrl: './reporte-venta-por-periodo.component.html',
  styleUrl: './reporte-venta-por-periodo.component.css'
})
export class ReporteVentaPorPeriodoComponent {
  form: FormGroup
  ventas: Venta[] = []

  constructor(private  http: HttpClient) {
    this.form = new FormGroup({
      mes: new FormControl(null, Validators.required),
      anio: new FormControl(null, Validators.required)
    });
  }

  onSubmit() {
    if (this.form.valid) {
      this.http.get<Venta[]>(`http://localhost:8080/reportes/ventas/periodo/${this.form.value.mes}/${this.form.value.anio}`).subscribe(
        (ventas) => {
          this.ventas = ventas
        }
      )
    }
  }
}
