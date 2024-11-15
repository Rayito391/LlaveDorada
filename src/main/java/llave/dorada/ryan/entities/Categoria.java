package llave.dorada.ryan.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroCategoria;

    private String descripcion;

    private LocalDate fechaRegistro;

    public Categoria() {
    }

    public Categoria(int numeroCategoria, String descripcion, LocalDate fechaRegistro) {
        this.numeroCategoria = numeroCategoria;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    public int getNumeroCategoria() {
        return numeroCategoria;
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
