package llave.dorada.ryan.dtos;

import java.time.LocalDate;

public class TipoClienteCreate {
    private final int numeroTipoCliente;
    private final String descripcion;
    private final LocalDate fechaRegistro;

    public TipoClienteCreate(int numeroTipoCliente, String descripcion, LocalDate fechaRegistro) {
        this.numeroTipoCliente = numeroTipoCliente;
        this.descripcion = descripcion;
        this.fechaRegistro = LocalDate.now();
    }

    public int getNumeroTipoCliente() {
        return numeroTipoCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
}
