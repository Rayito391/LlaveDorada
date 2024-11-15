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
import { Cliente, Venta } from '../types';

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
  selector: 'app-reporte-venta-cliente',
  templateUrl: './reporte-venta-cliente.component.html',
  styleUrls: ['./reporte-venta-cliente.component.css'],
})
export class ReporteVentaClienteComponent implements OnInit {
  form: FormGroup;
  clientes: Cliente[] = [];
  ventas: Venta[] = [];

  constructor(private http: HttpClient) {
    this.form = new FormGroup({
      numeroCliente: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {
    this.http
      .get<Cliente[]>('http://localhost:8080/clientes')
      .subscribe((clientes) => {
        this.clientes = clientes;
      });

    this.form.get('numeroCliente')?.valueChanges.subscribe((numeroCliente) => {
      if (numeroCliente) {
        this.obtenerVentasPorCliente(numeroCliente);
      }
    });
  }

  onClienteSeleccionado(numeroCliente: string): void {
    this.obtenerVentasPorCliente(numeroCliente);
  }

  obtenerVentasPorCliente(numeroCliente: string): void {
    this.http
      .get<Venta[]>(
        `http://localhost:8080/reportes/ventas/cliente/${numeroCliente}`
      )
      .subscribe((ventas) => {
        this.ventas = ventas;
      });
  }
}
