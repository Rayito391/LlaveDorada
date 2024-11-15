package llave.dorada.ryan.dtos;


import java.time.LocalDate;
import java.util.List;

public class ClienteCreate {
    private final String nombre;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final LocalDate fechaNacimiento;
    private final String domicilio;
    private final LocalDate fechaRegistro;
    private final int tipoCliente;
    private final List<Integer> ventasList;

    public ClienteCreate(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String domicilio, int tipoCliente) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.tipoCliente = tipoCliente;
        this.fechaRegistro = LocalDate.now();
        this.ventasList = List.of();
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public List<Integer> getVentasList() {
        return ventasList;
    }
}
