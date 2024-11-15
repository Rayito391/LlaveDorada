package llave.dorada.ryan.controllers;

import llave.dorada.ryan.dtos.ProductoCreate;
import llave.dorada.ryan.entities.Categoria;
import llave.dorada.ryan.entities.Producto;
import llave.dorada.ryan.repositories.CategoriaRepository;
import llave.dorada.ryan.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/productos")
public class ProductoController {
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoController(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Producto> getAllProducto() {
        return productoRepository.findByActivoTrue();
    }

    @GetMapping(path = "/{id}")
    public Producto getProducto(
            @PathVariable int id
    ) {
        Producto producto = productoRepository.findById(id).orElseThrow();
        return producto;
    }

    @GetMapping(path = "/descripcion/{descripcion}")
    public Producto getProductoPorDescripcion(
            @PathVariable String descripcion
    ) {
        Producto producto = productoRepository.findByDescripcion(descripcion);
        return producto;
    }

    @PostMapping
    public Producto addProducto(
            @RequestBody ProductoCreate productoCreate
    ) {
        Categoria categoria = categoriaRepository.findById(Math.toIntExact(productoCreate.getCategoria())).orElseThrow();
        Producto producto = new Producto(0, productoCreate.getDescripcion(),
                productoCreate.getPrecio(), productoCreate.getExistencia(), productoCreate.getFechaRegistro(), categoria, productoCreate.getActivo());
        return productoRepository.save(producto);
    }

    @PutMapping(path = "{id}")
    public Producto updateProducto(
            @PathVariable int id,
            @RequestBody ProductoCreate productoCreate
    ) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow();

        Categoria categoria = categoriaRepository.findById(Math.toIntExact(productoCreate.getCategoria()))
                .orElseThrow();

        producto.setDescripcion(productoCreate.getDescripcion());
        producto.setPrecio(productoCreate.getPrecio());
        producto.setExistencia(productoCreate.getExistencia());
        producto.setFechaRegistro(productoCreate.getFechaRegistro());
        producto.setCategoria(categoria);
        producto.setActivo(true);

        return productoRepository.save(producto);
    }

    @DeleteMapping(path = "{id}")
    public List<Producto> deleteProducto(@PathVariable int id) {
        Producto producto = productoRepository.findById(id).orElseThrow();
        producto.setActivo(false);
        productoRepository.save(producto);

        return productoRepository.findAll().stream()
                .filter(Producto::isActivo)
                .collect(Collectors.toList());
    }

}
