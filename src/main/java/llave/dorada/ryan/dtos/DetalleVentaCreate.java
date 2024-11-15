package llave.dorada.ryan.dtos;

public class DetalleVentaCreate {
    private int numeroVenta;
    private int numeroProducto;
    private int cantidad;

    public DetalleVentaCreate(int numeroVenta, int numeroProducto, int cantidad) {
        this.numeroVenta = numeroVenta;
        this.numeroProducto = numeroProducto;
        this.cantidad = cantidad;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public int getNumeroProducto() {
        return numeroProducto;
    }

    public void setNumeroProducto(int numeroProducto) {
        this.numeroProducto = numeroProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
