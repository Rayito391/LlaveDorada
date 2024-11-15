package llave.dorada.ryan.dtos;

import java.time.LocalDate;

public class CategoriaCreate {
    private final int numeroCategoria;
    private final String descripcion;
    private final LocalDate fechaRegistro;

    public CategoriaCreate(int numeroCategoria, String descripcion, LocalDate fechaRegistro) {
        this.numeroCategoria = numeroCategoria;
        this.descripcion = descripcion;
        this.fechaRegistro = LocalDate.now();
    }

    public int getNumeroCategoria() {
        return numeroCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
}
