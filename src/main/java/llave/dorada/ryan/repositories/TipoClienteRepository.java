package llave.dorada.ryan.repositories;

import llave.dorada.ryan.entities.TipoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoClienteRepository extends JpaRepository<TipoCliente, Integer> {
    TipoCliente findByDescripcion(String descripcion);
}
