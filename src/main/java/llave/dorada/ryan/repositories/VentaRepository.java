package llave.dorada.ryan.repositories;

import llave.dorada.ryan.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    List<Venta> findVentasByClienteAndFechaVentaAfter(Cliente cliente, LocalDate fecha);

    //ventas por cliente
    List<Venta> findByCliente(Cliente cliente);

    //ventas fecha especifica
    List<Venta> findByFechaVenta(LocalDate fechaVenta);

    //ventas en un periodo
    List<Venta> findByFechaVentaBetween(LocalDate startDate, LocalDate endDate);

    List<Venta> findAllByClienteTipoCliente(TipoCliente tipoCliente);

    List<Venta> findAllByDetalleVentasProducto(Producto producto);

    List<Venta> findAllByDetalleVentasProductoCategoria(Categoria categoria);
}


