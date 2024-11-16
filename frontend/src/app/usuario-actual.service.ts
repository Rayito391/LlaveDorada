import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Usuario } from './types';

@Injectable({
  providedIn: 'root'
})
export class UsuarioActualService {
  private usuarioSubject: BehaviorSubject<Usuario | null> = new BehaviorSubject<Usuario | null>(null);

  getUsuarioActual(): Observable<Usuario | null> {
    return this.usuarioSubject.asObservable();
  }

  setUsuarioActual(usuario: Usuario): void {

    this.usuarioSubject.next(usuario);
  }
}
