package llave.dorada.ryan.dtos;


import llave.dorada.ryan.entities.DetalleVenta;

import java.time.LocalDate;
import java.util.List;

public class VentaCreate {
    private int numeroCliente;
    private double total;
    private LocalDate fechaVenta;
    private List<DetalleVenta> detalleVentaList;


    public VentaCreate(int numeroCliente, LocalDate fechaVenta, List<DetalleVenta> detalleVentaList) {
        this.numeroCliente = numeroCliente;
        this.fechaVenta = LocalDate.now();
        this.detalleVentaList = detalleVentaList;
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

    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }
}
