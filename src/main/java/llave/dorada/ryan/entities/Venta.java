package llave.dorada.ryan.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroVenta;

    @ManyToOne

    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "venta")
    @JsonManagedReference
    private List<DetalleVenta> detalleVentas;

    private double total;
    private LocalDate fechaVenta;

    public Venta() {
    }

    public Venta(int numeroVenta, Cliente cliente, double total, LocalDate fechaVenta) {
        this.numeroVenta = numeroVenta;
        this.cliente = cliente;
        this.total = total;
        this.fechaVenta = fechaVenta;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(List<DetalleVenta> detalleVentaList) {
        this.detalleVentas = detalleVentaList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
