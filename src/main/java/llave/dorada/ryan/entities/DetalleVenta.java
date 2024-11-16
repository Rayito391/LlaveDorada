package llave.dorada.ryan.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroDetalleventa;

    @ManyToOne
    @JsonBackReference
    private Venta venta;

    @ManyToOne
    private Producto producto;

    private int cantidad;

    public DetalleVenta() {
    }

    public DetalleVenta(int numeroDetalleventa, Venta venta, Producto producto, int cantidad) {
        this.numeroDetalleventa = numeroDetalleventa;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getNumeroDetalleventa() {
        return numeroDetalleventa;
    }

    public void setNumeroDetalleventa(int numeroDetalleventa) {
        this.numeroDetalleventa = numeroDetalleventa;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta numeroVenta) {
        this.venta = numeroVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto numeroProducto) {
        this.producto = numeroProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
