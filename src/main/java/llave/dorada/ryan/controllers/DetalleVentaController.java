package llave.dorada.ryan.controllers;

import llave.dorada.ryan.entities.*;
import llave.dorada.ryan.repositories.DetalleVentaRepository;

import llave.dorada.ryan.repositories.VentaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/detalle-ventas")
public class DetalleVentaController {
    final DetalleVentaRepository detalleVentaRepository;
    final VentaRepository ventaRepository;

    public DetalleVentaController(DetalleVentaRepository detalleVentaRepository, VentaRepository ventaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
        this.ventaRepository = ventaRepository;
    }

    @GetMapping("/{id}")
    public List<DetalleVenta> getDetalles (@PathVariable int id){
        Venta venta = ventaRepository.findById(id).orElseThrow() ;
        List<DetalleVenta> detalleVentaList = detalleVentaRepository.findByVenta_NumeroVenta(venta.getNumeroVenta());
        return detalleVentaList;
    }

}

