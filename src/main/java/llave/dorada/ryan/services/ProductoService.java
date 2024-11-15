package llave.dorada.ryan.services;

import llave.dorada.ryan.entities.Producto;
import llave.dorada.ryan.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public boolean productoExiste(int id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return producto != null && producto.isActivo();
    }

    public boolean verificarExistencia(int id) {
        Producto producto = productoRepository.findById(id).orElseThrow();
        if (producto.getExistencia() <= 0) {
            producto.setActivo(false);
            productoRepository.save(producto);
            return false;
        }
        return true;
    }

}
