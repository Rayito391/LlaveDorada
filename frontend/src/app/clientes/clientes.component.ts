import {Component} from '@angular/core';
import {provideNativeDateAdapter} from "@angular/material/core";
import {ClienteFormComponent} from "../cliente-form/cliente-form.component";
import {Cliente} from "../types";
import {HttpClient} from "@angular/common/http";
import {MatButtonModule} from "@angular/material/button";
import {MatDividerModule} from "@angular/material/divider";
import {MatTableModule} from "@angular/material/table";

@Component({
  selector: 'app-clientes',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [ClienteFormComponent, MatButtonModule, MatDividerModule, MatTableModule],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.css',
})
export class ClientesComponent {
  clientes: Cliente[] = [];
  selectedCliente: Cliente | null = null;

  constructor(private http: HttpClient) {
    this.http.get<Cliente[]>('http://localhost:8080/clientes').subscribe(clientes => {
      this.clientes = clientes;
    });
  }

  eliminar(cliente: Cliente) {
    this.http.delete(`http://localhost:8080/clientes/${cliente.numeroCliente}`).subscribe(() => {
      window.location.reload();
    });
  }

  editar(cliente: Cliente) {
    this.selectedCliente = cliente;
  }
}
