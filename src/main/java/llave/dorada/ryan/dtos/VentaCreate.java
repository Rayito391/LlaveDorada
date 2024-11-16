package llave.dorada.ryan.dtos;


import llave.dorada.ryan.entities.DetalleVenta;

import java.time.LocalDate;
import java.util.List;

public class VentaCreate {
    private int numeroCliente;
    private double total;
    private LocalDate fechaVenta;
    private List<DetalleVentaCreate> detalleVentaCreateList;


    public VentaCreate(int numeroCliente, LocalDate fechaVenta, List<DetalleVentaCreate> detalleVentaCreateList) {
        this.numeroCliente = numeroCliente;
        this.fechaVenta = LocalDate.now();
        this.detalleVentaCreateList = detalleVentaCreateList;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
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

    public List<DetalleVentaCreate> getDetalleVentaCreateList() {
        return detalleVentaCreateList;
    }

    public void setDetalleVentaCreateList(List<DetalleVentaCreate> detalleVentaCreateList) {
        this.detalleVentaCreateList = detalleVentaCreateList;
    }
}
