package llave.dorada.ryan.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroProducto;

    private String descripcion;
    private double precio;
    private int existencia;
    private LocalDate fechaRegistro;

    @ManyToOne
    private Categoria categoria;
    private boolean activo = true;

    public Producto() {
    }

    public Producto(int numeroProducto) {
        this.numeroProducto = numeroProducto;
    }

    public Producto(int numeroProducto, String descripcion, double precio, int existencia, LocalDate fechaRegistro, Categoria categoria, boolean activo) {
        this.numeroProducto = numeroProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
        this.fechaRegistro = fechaRegistro;
        this.categoria = categoria;
        this.activo = activo;
    }

    public int getNumeroProducto() {
        return numeroProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
