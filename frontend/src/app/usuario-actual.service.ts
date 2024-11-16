import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { Usuario } from './types';

@Injectable({
  providedIn: 'root'
})
export class UsuarioActualService {
  private usuarioSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  getEsAdministrador(): Observable<boolean> {
    return this.usuarioSubject.asObservable();
  }

  setUsuarioActual(usuario: Usuario): void {
    this.usuarioSubject.next(usuario.tipoUsuario.descripcionTipoUsuario === 'Administrador');
  }
}
