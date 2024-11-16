/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { ReporteVentaPorFechaComponent } from './reporte-venta-por-fecha.component';

describe('ReporteVentaPorFechaComponent', () => {
  let component: ReporteVentaPorFechaComponent;
  let fixture: ComponentFixture<ReporteVentaPorFechaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReporteVentaPorFechaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteVentaPorFechaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
