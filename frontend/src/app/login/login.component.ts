import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';

interface Categoria {
  numeroCategoria: number;
  descripcion: string;
  fechaRegistro: string;
}

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [MatSelectModule, MatFormFieldModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  categorias: Categoria[] = [];

  ngOnInit() {
    this.http.get('http://localhost:8080/categorias').subscribe((data) => {
      this.categorias = data as Categoria[];
    });
  }

  constructor(private http: HttpClient) {}
}
