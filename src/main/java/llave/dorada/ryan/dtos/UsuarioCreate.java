package llave.dorada.ryan.dtos;

import java.time.LocalDate;

public class UsuarioCreate {

    private final String nombre;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final LocalDate fechaRegistro;
    private String email;
    private String contrasena;
    private final int tipoUsuario;

    public UsuarioCreate(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaRegistro, String email, String contrasena, int tipoUsuario) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaRegistro = fechaRegistro;
        this.email = email;
        this.contrasena = contrasena;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
