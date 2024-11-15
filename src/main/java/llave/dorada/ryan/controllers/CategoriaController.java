package llave.dorada.ryan.controllers;

import llave.dorada.ryan.dtos.CategoriaCreate;
import llave.dorada.ryan.entities.Categoria;
import llave.dorada.ryan.repositories.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {
    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public Categoria addCategoria(
            @RequestBody CategoriaCreate categoriaCreate
    ) {
        Categoria categoria = new Categoria(
                categoriaCreate.getNumeroCategoria(),
                categoriaCreate.getDescripcion(),
                categoriaCreate.getFechaRegistro()
        );
        return categoriaRepository.save(categoria);
    }
}
