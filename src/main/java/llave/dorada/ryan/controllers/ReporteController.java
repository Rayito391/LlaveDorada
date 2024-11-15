package llave.dorada.ryan.controllers;

import llave.dorada.ryan.entities.*;
import llave.dorada.ryan.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping(path = "/reportes")
public class ReporteController {

    private final ClienteRepository clienteRepository;
    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;
    private final DetalleVentaRepository detalleVentaRepository;
    private final CategoriaRepository categoriaRepository;
    private final TipoClienteRepository tipoClienteRepository;

    @Autowired
    public ReporteController(ClienteRepository clienteRepository, VentaRepository ventaRepository,
                             ProductoRepository productoRepository, DetalleVentaRepository detalleVentaRepository,
                             CategoriaRepository categoriaRepository, TipoClienteRepository tipoClienteRepository) {
        this.clienteRepository = clienteRepository;
        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;
        this.detalleVentaRepository = detalleVentaRepository;
        this.categoriaRepository = categoriaRepository;
        this.tipoClienteRepository = tipoClienteRepository;
    }

    //por cliente
    @GetMapping("/ventas/cliente/{numeroCliente}")
    public List<Venta> obtenerVentasPorCliente(@PathVariable Integer numeroCliente) {
        Cliente cliente = clienteRepository.findById(numeroCliente).orElseThrow();

        return ventaRepository.findByCliente(cliente);
    }

    //detalle por venta
    @GetMapping("/ventas/detalle/{numeroVenta}")
    public List<DetalleVenta> obtenerReporteVenta(@PathVariable Integer numeroVenta) {
        Venta venta = ventaRepository.findById(numeroVenta).orElseThrow();

        List<DetalleVenta> detalleVentaList = venta.getDetalleVentas();
        return detalleVentaList;
    }

    //ventas por fecha
    @GetMapping("/ventas/fecha/{fechaVenta}")
    public List<Venta> ventasFechaEspecifica(@PathVariable String fechaVenta) {
        LocalDate fecha = LocalDate.parse(fechaVenta);

        List<Venta> ventaList = ventaRepository.findByFechaVenta(fecha);

        return ventaList;
    }

    //ventas de un mes y año específico
    @GetMapping("/ventas/periodo/{mes}/{año}")
    public List<Venta> ventasPorPeriodo(@PathVariable int mes, @PathVariable int año) {
        YearMonth yearMonth = YearMonth.of(año, mes);
        LocalDate startDate = yearMonth.atDay(1);
        LocalDate endDate = yearMonth.atEndOfMonth();

        List<Venta> ventas = ventaRepository.findByFechaVentaBetween(startDate, endDate);

        return ventas;
    }

    @GetMapping("/ventas/tipo_cliente/{tipoClienteId}")
    public List<Venta> ventasPorTipoCliente(@PathVariable Integer tipoClienteId) {
        TipoCliente tipoCliente = tipoClienteRepository.findById(tipoClienteId).orElseThrow();
        return ventaRepository.findAllByClienteTipoCliente(tipoCliente);
    }

    @GetMapping("/ventas/producto/{productoId}")
    public List<Venta> ventasPorProducto(@PathVariable Integer productoId) {
        Producto producto = productoRepository.findById(productoId).orElseThrow();
        return ventaRepository.findAllByDetalleVentasProducto(producto);
    }

    @GetMapping("/ventas/categoria/{categoriaId}")
    public List<Venta> ventasPorCategoria(@PathVariable Integer categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId).orElseThrow();
        return ventaRepository.findAllByDetalleVentasProductoCategoria(categoria);
    }
}
