import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {Categoria, Producto, TipoUsuario, Usuario} from "../types";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatButtonModule} from "@angular/material/button";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatSelectModule} from "@angular/material/select";

@Component({
  selector: 'app-productos-form',
  standalone: true,
  imports: [MatInputModule, MatFormFieldModule, MatButtonModule, MatDatepickerModule, ReactiveFormsModule, MatSelectModule, HttpClientModule],
  templateUrl: './productos-form.component.html',
  styleUrl: './productos-form.component.css'
})
export class ProductosFormComponent implements OnChanges {
  @Input() producto: Producto | null = null
  categorias: Categoria[] = [];
  form: FormGroup

  constructor(private http: HttpClient) {
    this.form = new FormGroup({
      descripcion: new FormControl('', Validators.required),
      precio: new FormControl('', Validators.required),
      existencia: new FormControl('', Validators.required),
      categoria: new FormControl('', Validators.required),
    });
    http.get<Categoria[]>("http://localhost:8080/categorias").subscribe(categoria => {
      this.categorias = categoria;
    })
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['producto'] && this.producto) {
      this.form.patchValue({
        descripcion: this.producto.descripcion,
        precio: this.producto.precio,
        existencia: this.producto.existencia,
        categoria: this.producto.categoria.numeroCategoria
      })
    }
  }

  onSubmit() {
    if (this.form.valid) {
      if (!this.producto) {
        this.http.post("http://localhost:8080/productos", {
          descripcion: this.form.value.descripcion,
          precio: this.form.value.precio,
          existencia: this.form.value.existencia,
          categoria: this.form.value.categoria,
        }).subscribe(() => {
          window.location.reload();
        })
      } else {
        this.http.put(`http://localhost:8080/productos/${this.producto.numeroProducto}`, {
          descripcion: this.form.value.descripcion,
          precio: this.form.value.precio,
          existencia: this.form.value.existencia,
          categoria: this.form.value.categoria,
        }).subscribe(() => {
          window.location.reload();
        })
      }
    }
  }
}
