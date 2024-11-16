import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {MatFormField, MatFormFieldModule} from "@angular/material/form-field";
import {MatSelect, MatSelectModule} from "@angular/material/select";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {Cliente, TipoCliente, Venta} from "../types";
import {CurrencyPipe} from "@angular/common";

@Component({
  selector: 'app-reporte-venta-por-tipo-cliente',
  standalone: true,
  imports: [HttpClientModule, MatFormFieldModule, MatSelectModule, ReactiveFormsModule, CurrencyPipe],
  templateUrl: './reporte-venta-por-tipo-cliente.component.html',
  styleUrl: './reporte-venta-por-tipo-cliente.component.css'
})
export class ReporteVentaPorTipoClienteComponent implements OnInit{
  tipoClientes: TipoCliente[] = [];
  ventas: Venta[] = [];
  form: FormGroup = new FormGroup({
    tipoCliente: new FormControl()
  });

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get<TipoCliente[]>('http://localhost:8080/tipo-cliente').subscribe(tipoClientes => {
      this.tipoClientes = tipoClientes;
    });

    this.form.get('tipoCliente')?.valueChanges.subscribe((tipoCliente) => {
      if (tipoCliente) {
        this.http.get<Venta[]>(`http://localhost:8080/reportes/ventas/tipo_cliente/${tipoCliente}`).subscribe(ventas => {
          this.ventas = ventas;
        });
      }
    });
  }
}
