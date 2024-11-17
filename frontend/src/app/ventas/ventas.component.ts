import { Component, OnInit } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { Cliente, DetalleVenta, Producto, Usuario, Venta } from '../types';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { JsonPipe, NgIf } from '@angular/common';
import { UsuarioActualService } from '../usuario-actual.service';

@Component({
  selector: 'app-ventas',
  standalone: true,
  imports: [
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    HttpClientModule,
    MatButtonModule,
    ReactiveFormsModule,
    JsonPipe,
    NgIf,
  ],
  templateUrl: './ventas.component.html',
  styleUrl: './ventas.component.css',
})
export class VentasComponent implements OnInit {
  clientes: Cliente[] = [];
  productos: Producto[] = [];
  ventas: Venta[] = [];
  detalleVentas: {
    numeroProducto: number;
    cantidad: number;
  }[] = [];
  agregarDetalleVentaForm = new FormGroup({
    producto: new FormControl('', Validators.required),
    cantidad: new FormControl('', [Validators.required, Validators.min(1)]),
  });
  ventaForm = new FormGroup({
    cliente: new FormControl('', Validators.required),
  });
  esAdministrador = false;

  constructor(
    private http: HttpClient,
    private usuarioActualService: UsuarioActualService
  ) {}

  ngOnInit() {
    this.http
      .get<Producto[]>('http://localhost:8080/productos')
      .subscribe((productos) => {
        this.productos = productos;
      });
    this.http
      .get<Cliente[]>('http://localhost:8080/clientes')
      .subscribe((clientes) => {
        this.clientes = clientes;
      });
    this.http
      .get<Venta[]>('http://localhost:8080/ventas')
      .subscribe((ventas) => {
        this.ventas = ventas;
      });
    this.usuarioActualService
      .getEsAdministrador()
      .subscribe((esAdministrador) => {
        this.esAdministrador = esAdministrador;
      });
  }

  agregarDetalleVenta() {
    const cantidad = this.agregarDetalleVentaForm.value.cantidad;
    if (cantidad === null || cantidad === undefined || Number(cantidad) <= 0)
      return;

    this.detalleVentas.push({
      numeroProducto: Number(this.agregarDetalleVentaForm.value.producto),
      cantidad: Number(this.agregarDetalleVentaForm.value.cantidad),
    });
    this.agregarDetalleVentaForm.reset();
  }

  crearVenta() {
    if (this.detalleVentas.length === 0) return;

    this.http
      .post('http://localhost:8080/ventas', {
        numeroCliente: Number(this.ventaForm.value.cliente),
        detalleVentaCreateList: this.detalleVentas,
      })
      .subscribe(() => {
        window.location.reload();
      });
  }

  eliminarVenta(venta: Venta) {
    this.http
      .delete(`http://localhost:8080/ventas/${venta.numeroVenta}`)
      .subscribe(() => {
        window.location.reload();
      });
  }
}
