package llave.dorada.ryan.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroTipoUsuario;
    private String descripcionTipoUsuario;
    private LocalDate fechaRegistro;


    public TipoUsuario() {
    }

    public TipoUsuario(int numeroTipoUsuario, String descripcionTipoUsuario, LocalDate fechaRegistro) {
        this.numeroTipoUsuario = numeroTipoUsuario;
        this.descripcionTipoUsuario = descripcionTipoUsuario;
        this.fechaRegistro = fechaRegistro;
    }

    public int getNumeroTipoUsuario() {
        return numeroTipoUsuario;
    }

    public void setNumeroTipoUsuario(int numeroTipoUsuario) {
        this.numeroTipoUsuario = numeroTipoUsuario;
    }

    public String getDescripcionTipoUsuario() {
        return descripcionTipoUsuario;
    }

    public void setDescripcionTipoUsuario(String descripcionTipoUsuario) {
        this.descripcionTipoUsuario = descripcionTipoUsuario;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
