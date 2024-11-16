import {Component, OnInit} from '@angular/core';
import {CurrencyPipe} from "@angular/common";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {Categoria, Venta} from "../types";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-reporte-venta-por-categoria',
  standalone: true,
  imports: [
    HttpClientModule, MatFormFieldModule, MatSelectModule, ReactiveFormsModule, CurrencyPipe
  ],
  templateUrl: './reporte-venta-por-categoria.component.html',
  styleUrl: './reporte-venta-por-categoria.component.css'
})
export class ReporteVentaPorCategoriaComponent implements OnInit {
  categorias: Categoria[] = [];
  ventas: Venta[] = [];
  form: FormGroup = new FormGroup({
    categoria: new FormControl()
  });

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get<Categoria[]>('http://localhost:8080/categorias').subscribe(categorias => {
      this.categorias = categorias;
    });

    this.form.get('categoria')?.valueChanges.subscribe((categoria) => {
      if (categoria) {
        this.http.get<Venta[]>(`http://localhost:8080/reportes/ventas/categoria/${categoria}`).subscribe(ventas => {
          this.ventas = ventas;
        });
      }
    });
  }
}
