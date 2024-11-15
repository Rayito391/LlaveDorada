import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import {Usuario} from "./types";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect, MatSelectModule} from "@angular/material/select";
import {ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, HttpClientModule, MatFormFieldModule, MatSelectModule, ReactiveFormsModule],
  templateUrl: './app.component.html',
})
export class AppComponent {
  usuarios: Usuario[] = []

  constructor(private http: HttpClient) {
    this.http.get<Usuario[]>('http://localhost:8080/usuarios').subscribe((usuarios) => {
      this.usuarios = usuarios
    })
  }
}
