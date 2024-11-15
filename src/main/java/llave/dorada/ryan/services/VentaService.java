package llave.dorada.ryan.services;

import llave.dorada.ryan.entities.DetalleVenta;
import llave.dorada.ryan.entities.Producto;
import llave.dorada.ryan.repositories.ProductoRepository;
import llave.dorada.ryan.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    private final ProductoRepository productoRepository;
    private final VentaRepository ventaRepository;


    @Autowired
    public VentaService(ProductoRepository productoRepository, VentaRepository ventaRepository) {
        this.productoRepository = productoRepository;
        this.ventaRepository = ventaRepository;
    }

    public double calcularTotalVenta(List<DetalleVenta> detalleVentaList) {
        double totalVenta = 0.0;

        for (DetalleVenta detalleVenta : detalleVentaList) {
            Producto producto = productoRepository.findById(detalleVenta.getProducto()).orElseThrow();

            double totalProducto = producto.getPrecio() * detalleVenta.getCantidad();
            totalVenta += totalProducto;
        }
        return totalVenta;
    }

}