import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatButtonModule} from "@angular/material/button";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatSelectModule} from "@angular/material/select";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {provideNativeDateAdapter} from "@angular/material/core";
import {TipoUsuario, Usuario} from "../types";

@Component({
  selector: 'app-usuarios-from',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatInputModule, MatFormFieldModule, MatButtonModule, MatDatepickerModule, ReactiveFormsModule, MatSelectModule, HttpClientModule,],
  templateUrl: './usuarios-from.component.html',
  styleUrl: './usuarios-from.component.css'
})
export class UsuariosFromComponent implements OnChanges {
  @Input() usuario: Usuario | null = null
  tipoUsuarios: TipoUsuario[] = [];
  form: FormGroup

  constructor(private http: HttpClient) {
    this.form = new FormGroup({
      nombre: new FormControl('', Validators.required),
      apellidoPaterno: new FormControl('', Validators.required),
      apellidoMaterno: new FormControl('', Validators.required),
      tipoUsuario: new FormControl('', Validators.required),
    });
    http.get<TipoUsuario[]>("http://localhost:8080/tipo-usuario").subscribe(tipoUsuario => {
      this.tipoUsuarios = tipoUsuario;
    })
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['usuario'] && this.usuario) {
      this.form.patchValue({
        nombre: this.usuario.nombre,
        apellidoPaterno: this.usuario.apellidoPaterno,
        apellidoMaterno: this.usuario.apellidoMaterno,
        tipoUsuario: this.usuario.tipoUsuario.numeroTipoUsuario,
      })
    }
  }

  onSubmit() {
    if (this.form.valid) {
      if (!this.usuario) {
        this.http.post("http://localhost:8080/usuarios", {
          nombre: this.form.value.nombre,
          apellidoPaterno: this.form.value.apellidoPaterno,
          apellidoMaterno: this.form.value.apellidoMaterno,
          tipoUsuario: this.form.value.tipoUsuario,
        }).subscribe(() => {
          window.location.reload();
        })
      } else {
        this.http.put(`http://localhost:8080/usuarios/${this.usuario.numeroUsuario}`, {
          nombre: this.form.value.nombre,
          apellidoPaterno: this.form.value.apellidoPaterno,
          apellidoMaterno: this.form.value.apellidoMaterno,
          tipoUsuario: this.form.value.tipoUsuario,
        }).subscribe(() => {
          window.location.reload();
        })
      }
    }
  }
}
