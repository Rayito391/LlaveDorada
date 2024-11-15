package llave.dorada.ryan.dtos;

import java.time.LocalDate;

public class TipoUsuarioCreate {

    private final int numeroTipoUsuario;
    private final String descripcionTipoUsuario;
    private final LocalDate fechaRegistro;

    public TipoUsuarioCreate(int numeroTipoUsuario, String descripcionTipoUsuario, LocalDate fechaRegistro) {
        this.numeroTipoUsuario = numeroTipoUsuario;
        this.descripcionTipoUsuario = descripcionTipoUsuario;
        this.fechaRegistro = LocalDate.now();
    }

    public int getNumeroTipoUsuario() {
        return numeroTipoUsuario;
    }

    public String getDescripcionTipoUsuario() {
        return descripcionTipoUsuario;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
}
