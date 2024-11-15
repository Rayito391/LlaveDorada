import { Component } from '@angular/core';
import { Producto } from '../types';
import { HttpClient } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { ProductosFormComponent } from '../productos-form/productos-form.component';
import { UsuariosFromComponent } from '../usuarios-from/usuarios-from.component';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [
    ProductosFormComponent,
    UsuariosFromComponent,
    MatButtonModule,
    MatDividerModule,
  ],
  templateUrl: './productos.component.html',
  styleUrl: './productos.component.css',
})
export class ProductosComponent {
  productos: Producto[] = [];
  selectedProducto: Producto | null = null;

  constructor(private http: HttpClient) {
    this.http
      .get<Producto[]>('http://localhost:8080/productos')
      .subscribe((producto) => {
        this.productos = producto;
      });
  }

  eliminar(producto: Producto) {
    this.http
      .delete(`http://localhost:8080/productos/${producto.numeroProducto}`)
      .subscribe(() => {
        window.location.reload();
      });
  }

  editar(usuario: Producto) {
    this.selectedProducto = usuario;
  }
}
