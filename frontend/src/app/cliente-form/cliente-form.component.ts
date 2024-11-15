import {Component, Input, OnChanges, SimpleChange, SimpleChanges} from '@angular/core';
import {MatButtonModule} from "@angular/material/button";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {provideNativeDateAdapter} from "@angular/material/core";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Cliente, TipoCliente} from "../types";
import {MatSelectModule} from "@angular/material/select";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-cliente-form',
  standalone: true,
  providers: [provideNativeDateAdapter(), DatePipe],
  imports: [
    MatInputModule, MatFormFieldModule, MatButtonModule, MatDatepickerModule, ReactiveFormsModule, MatSelectModule, HttpClientModule,
  ],
  templateUrl: './cliente-form.component.html',
  styleUrl: './cliente-form.component.css'
})
export class ClienteFormComponent implements OnChanges {
  @Input() cliente: Cliente | null = null
  tipoClientes: TipoCliente[] = [];
  form: FormGroup

  constructor(private http: HttpClient, private datePipe: DatePipe) {
    this.form = new FormGroup({
      nombre: new FormControl('', Validators.required),
      apellidoPaterno: new FormControl('', Validators.required),
      apellidoMaterno: new FormControl('', Validators.required),
      fechaNacimiento: new FormControl('', Validators.required),
      domicilio: new FormControl('', Validators.required),
      tipoCliente: new FormControl('', Validators.required),
    });
    http.get<TipoCliente[]>("http://localhost:8080/tipo-cliente").subscribe(tipoClientes => {
      this.tipoClientes = tipoClientes;
    })
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['cliente'] && this.cliente) {
      this.form.patchValue({
        nombre: this.cliente.nombre,
        apellidoPaterno: this.cliente.apellidoPaterno,
        apellidoMaterno: this.cliente.apellidoMaterno,
        fechaNacimiento: this.cliente.fechaNacimiento,
        domicilio: this.cliente.domicilio,
        tipoCliente: this.cliente.tipoCliente.numeroTipoCliente,
      })
    }
  }

  onSubmit() {
    if (this.form.valid) {
      const formattedDate = this.datePipe.transform(this.form.value.fechaNacimiento, 'yyyy-MM-dd');
      if (!this.cliente) {
        this.http.post("http://localhost:8080/clientes", {
          nombre: this.form.value.nombre,
          apellidoPaterno: this.form.value.apellidoPaterno,
          apellidoMaterno: this.form.value.apellidoMaterno,
          domicilio: this.form.value.domicilio,
          fechaNacimiento: formattedDate,
          tipoCliente: this.form.value.tipoCliente,
        }).subscribe(() => {
          window.location.reload();
        })
      } else {
        this.http.put(`http://localhost:8080/clientes/${this.cliente.numeroCliente}`, {
          nombre: this.form.value.nombre,
          apellidoPaterno: this.form.value.apellidoPaterno,
          apellidoMaterno: this.form.value.apellidoMaterno,
          domicilio: this.form.value.domicilio,
          fechaNacimiento: formattedDate,
          tipoCliente: this.form.value.tipoCliente,
        }).subscribe(() => {
          window.location.reload();
        })
      }
    }
  }
}
