package llave.dorada.ryan.dtos;

import java.time.LocalDate;

public class ProductoCreate {
    private final String descripcion;
    private final double precio;
    private final int existencia;
    private final LocalDate fechaRegistro;
    private final int categoria;
    private boolean activo;

    public ProductoCreate(String descripcion, double precio, int existencia, int categoria) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
        this.fechaRegistro = LocalDate.now();
        this.categoria = categoria;
        this.activo = existencia > 0;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public int getCategoria() {
        return categoria;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
