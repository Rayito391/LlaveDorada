import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { UsuarioComponent } from './usuario/usuario.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginComponent, UsuarioComponent, HttpClientModule],
  templateUrl: './app.component.html',
})
export class AppComponent {
  nombre = 'Rayo Felix de Jesus';
}
