package llave.dorada.ryan.repositories;

import llave.dorada.ryan.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Producto findByDescripcion(String descripcion);

    List<Producto> findByActivoTrue();
}
