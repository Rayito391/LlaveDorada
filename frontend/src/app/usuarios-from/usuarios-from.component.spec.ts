import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuariosFromComponent } from './usuarios-from.component';

describe('UsuariosFromComponent', () => {
  let component: UsuariosFromComponent;
  let fixture: ComponentFixture<UsuariosFromComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UsuariosFromComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UsuariosFromComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
