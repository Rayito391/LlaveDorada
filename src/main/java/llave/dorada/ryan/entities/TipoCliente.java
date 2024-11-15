package llave.dorada.ryan.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class TipoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroTipoCliente;
    private String descripcion;
    private LocalDate fechaRegistro;

    public TipoCliente() {
    }

    public TipoCliente(int numeroTipoCliente, String descripcion, LocalDate fechaRegistro) {
        this.numeroTipoCliente = numeroTipoCliente;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    public int getNumeroTipoCliente() {
        return numeroTipoCliente;
    }

    public void setNumeroTipoCliente(int numeroTipoCliente) {
        this.numeroTipoCliente = numeroTipoCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
