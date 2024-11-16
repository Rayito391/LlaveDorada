import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule } from '@angular/common';
import {
  FormControl,
  FormGroup,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';
import { Cliente, DetalleVenta, Venta } from '../types';

@Component({
  standalone: true,
  imports: [
    CommonModule,
    MatButtonModule,
    MatDividerModule,
    MatTableModule,
    MatInputModule,
    MatSelectModule,
    MatFormFieldModule,
    ReactiveFormsModule,
  ],
  selector: 'app-reporte-detalle-venta',
  templateUrl: './reporte-detalle-venta.component.html',
  styleUrls: ['./reporte-detalle-venta.component.css'],
})
export class ReporteDetalleVentaComponent implements OnInit {
  form: FormGroup;
  ventas: Venta[] = [];
  detalles: DetalleVenta[] = [];

  constructor(private http: HttpClient) {
    this.form = new FormGroup({
      numeroVenta: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {
    this.http
      .get<Venta[]>('http://localhost:8080/ventas')
      .subscribe((ventas) => {
        this.ventas = ventas;
      });

    this.form.get('numeroVenta')?.valueChanges.subscribe((numeroVenta) => {
      if (numeroVenta) {
        this.obtenerDetallesPorVentas(numeroVenta);
      }
    });
  }

  onVentaSeleccionado(numeroVenta: string): void {
    this.obtenerDetallesPorVentas(numeroVenta);
  }

  obtenerDetallesPorVentas(numeroVenta: string): void {
    this.http
      .get<DetalleVenta[]>(
        `http://localhost:8080/reportes/ventas/detalle/${numeroVenta}`
      )
      .subscribe((detalles) => {
        this.detalles = detalles;
      });
    console.log(this.detalles);
  }
}
