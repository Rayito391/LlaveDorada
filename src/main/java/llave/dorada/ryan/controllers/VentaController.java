package llave.dorada.ryan.controllers;

import llave.dorada.ryan.dtos.VentaCreate;
import llave.dorada.ryan.entities.Cliente;
import llave.dorada.ryan.entities.DetalleVenta;
import llave.dorada.ryan.entities.Producto;
import llave.dorada.ryan.entities.Venta;
import llave.dorada.ryan.repositories.ClienteRepository;
import llave.dorada.ryan.repositories.DetalleVentaRepository;
import llave.dorada.ryan.repositories.ProductoRepository;
import llave.dorada.ryan.repositories.VentaRepository;
import llave.dorada.ryan.services.ClienteService;
import llave.dorada.ryan.services.ProductoService;
import llave.dorada.ryan.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/ventas")
public class VentaController {
    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private VentaService ventaService;


    public VentaController(VentaRepository ventaRepository, DetalleVentaRepository detalleVentaRepository, ClienteRepository clienteRepository, ProductoRepository productoRepository, ClienteService clienteService, ProductoService productoService) {
        this.ventaRepository = ventaRepository;
        this.detalleVentaRepository = detalleVentaRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
        this.clienteService = clienteService;
        this.productoService = productoService;
    }

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @PostMapping(path = "")
    public Venta addVenta(@RequestBody VentaCreate ventaCreate) {
        Cliente cliente = clienteRepository.findById(ventaCreate.getNumeroCliente()).orElseThrow();

        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setFechaVenta(ventaCreate.getFechaVenta());

        double totalVenta = ventaService.calcularTotalVenta(ventaCreate.getDetalleVentaList());

        List<DetalleVenta> detalleVentaList = new ArrayList<>();

        for (DetalleVenta detalleVentaCreate : ventaCreate.getDetalleVentaList()) {
            int numeroProducto = detalleVentaCreate.getProducto();

            if (!productoService.productoExiste(numeroProducto) || !productoService.verificarExistencia(numeroProducto)) {
                throw new RuntimeException();
            }

            Producto producto = productoRepository.findById(detalleVentaCreate.getProducto()).orElseThrow();

            int cantidadVenta = detalleVentaCreate.getCantidad();
            if (producto.getExistencia() < cantidadVenta) {
                throw new RuntimeException();
            }
            producto.setExistencia(producto.getExistencia() - cantidadVenta);
            productoRepository.save(producto);

            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setVenta(venta);
            detalleVenta.setProducto(producto);
            detalleVenta.setCantidad(detalleVentaCreate.getCantidad());

            detalleVentaList.add(detalleVenta);
        }

        double totalConDescuento = clienteService.calcularDescuento(ventaCreate.getNumeroCliente(), totalVenta);

        venta.setTotal(totalConDescuento);
        venta.setDetalleVentas(detalleVentaList);

        venta = ventaRepository.save(venta);

        clienteService.actualizarTipoCliente(ventaCreate.getNumeroCliente());

        return venta;
    }

    @DeleteMapping(path = "/{numeroVenta}")
    public List<Venta> eliminarVenta(@PathVariable("numeroVenta") int numeroVenta) {
        Venta ventaExistente = ventaRepository.findById(numeroVenta)
                .orElseThrow();

        for (DetalleVenta detalleVenta : ventaExistente.getDetalleVentas()) {
            int numeroProducto = detalleVenta.getProducto();
            Producto producto = productoRepository.findById(numeroProducto).orElseThrow();
            int cantidadVenta = detalleVenta.getCantidad();
            producto.setExistencia(producto.getExistencia() + cantidadVenta);
            productoRepository.save(producto);
        }

        ventaRepository.delete(ventaExistente);

        return ventaRepository.findAll();
    }

}
