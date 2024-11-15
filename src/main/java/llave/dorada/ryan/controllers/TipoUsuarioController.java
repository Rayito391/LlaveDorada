package llave.dorada.ryan.controllers;

import llave.dorada.ryan.dtos.TipoUsuarioCreate;
import llave.dorada.ryan.entities.TipoUsuario;
import llave.dorada.ryan.repositories.TipoUsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tipo-usuario")
public class TipoUsuarioController {
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioController(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @GetMapping
    public List<TipoUsuario> getAllTipoUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    @PostMapping
    public TipoUsuario addTipoUsuario(
            @RequestBody TipoUsuarioCreate tipoUsuarioCreate
    ) {
        TipoUsuario tipoUsuario = new TipoUsuario(
                tipoUsuarioCreate.getNumeroTipoUsuario(),
                tipoUsuarioCreate.getDescripcionTipoUsuario(),
                tipoUsuarioCreate.getFechaRegistro()
        );
        return tipoUsuarioRepository.save(tipoUsuario);
    }
}
