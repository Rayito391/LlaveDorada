import { Component } from '@angular/core';
import {ClienteFormComponent} from "../cliente-form/cliente-form.component";
import {MatButton, MatButtonModule} from "@angular/material/button";
import {MatDivider, MatDividerModule} from "@angular/material/divider";
import {UsuariosFromComponent} from "../usuarios-from/usuarios-from.component";
import {Cliente, Usuario} from "../types";
import {HttpClient} from "@angular/common/http";
import {UsuarioActualService} from "../usuario-actual.service";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-usuarios',
  standalone: true,
  imports: [
    MatButtonModule,
    MatDividerModule,
    UsuariosFromComponent,
    NgIf
  ],
  templateUrl: './usuarios.component.html',
  styleUrl: './usuarios.component.css'
})
export class UsuariosComponent {
  usuarios: Usuario[] = [];
  selectedUsuario: Usuario | null = null;
  esAdministrador = false;

  constructor(private http: HttpClient, private usuarioActualService: UsuarioActualService) {
    this.http.get<Usuario[]>('http://localhost:8080/usuarios').subscribe(usuario => {
      this.usuarios = usuario;
    });
    usuarioActualService.getEsAdministrador().subscribe(esAdministrador => {
      this.esAdministrador = esAdministrador
    })
  }

  eliminar(usuario: Usuario) {
    this.http.delete(`http://localhost:8080/usuarios/${usuario.numeroUsuario}`).subscribe(() => {
      window.location.reload();
    });
  }

  editar(usuario: Usuario) {
    this.selectedUsuario = usuario;
  }
}

