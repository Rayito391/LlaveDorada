import {Component} from '@angular/core';
import {provideNativeDateAdapter} from "@angular/material/core";
import {ClienteFormComponent} from "../cliente-form/cliente-form.component";
import {Cliente} from "../types";
import {HttpClient} from "@angular/common/http";
import {MatButtonModule} from "@angular/material/button";
import {MatDividerModule} from "@angular/material/divider";
import {MatTableModule} from "@angular/material/table";
import {UsuarioActualService} from "../usuario-actual.service";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-clientes',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [ClienteFormComponent, MatButtonModule, MatDividerModule, MatTableModule, NgIf],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.css',
})
export class ClientesComponent {
  clientes: Cliente[] = [];
  selectedCliente: Cliente | null = null;
  esAdmininistrador = false;

  constructor(private http: HttpClient, private usuarioActualService: UsuarioActualService) {
    this.http.get<Cliente[]>('http://localhost:8080/clientes').subscribe(clientes => {
      this.clientes = clientes;
    });
    this.usuarioActualService.getEsAdministrador().subscribe(esAdmininistrador => {
      this.esAdmininistrador = esAdmininistrador;
    })
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
