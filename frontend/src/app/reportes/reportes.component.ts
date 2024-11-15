import { Component } from '@angular/core';
import { ReportesFormComponent } from '../reportes-form/reportes-form.component';
import { Categoria, Producto, TipoUsuario, Usuario } from '../types';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';

@Component({
  selector: 'app-reportes',
  standalone: true,
  imports: [ReportesFormComponent, MatInputModule, MatSelectModule],
  templateUrl: './reportes.component.html',
  styleUrl: './reportes.component.css',
})
export class ReportesComponent {}
