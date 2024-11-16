import {Component, OnChanges, SimpleChanges} from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import {Usuario} from "./types";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect, MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {UsuarioActualService} from "./usuario-actual.service";
import {JsonPipe} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
  providers: [UsuarioActualService],
  imports: [RouterOutlet, RouterLink, RouterLinkActive, HttpClientModule, MatFormFieldModule, MatSelectModule, ReactiveFormsModule, JsonPipe, FormsModule],
  templateUrl: './app.component.html',
})
export class AppComponent implements OnChanges {
  usuarios: Usuario[] = []
  selectedUsuario: Usuario | null = null

  constructor(private http: HttpClient, private usuarioActualService: UsuarioActualService) {
    this.http.get<Usuario[]>('http://localhost:8080/usuarios').subscribe((usuarios) => {
      this.usuarios = usuarios
    })
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['selectedUsuario'] && this.selectedUsuario) {
      this.usuarioActualService.setUsuarioActual(this.selectedUsuario)
    }
  }

  changeUsuario(usuario: Usuario) {
    this.usuarioActualService.setUsuarioActual(usuario)
  }
}
