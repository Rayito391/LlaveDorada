package llave.dorada.ryan.dtos;

import java.time.LocalDate;

public class UsuarioCreate {

    private final String nombre;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final LocalDate fechaRegistro;
    private final int tipoUsuario;

    public UsuarioCreate(String nombre, String apellidoPaterno, String apellidoMaterno, int tipoUsuario) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaRegistro = LocalDate.now();
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }
}
