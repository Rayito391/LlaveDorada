package llave.dorada.ryan.controllers;

import llave.dorada.ryan.dtos.TipoClienteCreate;
import llave.dorada.ryan.entities.TipoCliente;
import llave.dorada.ryan.repositories.TipoClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tipo-cliente")
public class TipoClienteController {
    private final TipoClienteRepository tipoClienteRepository;

    public TipoClienteController(TipoClienteRepository tipoClienteRepository) {
        this.tipoClienteRepository = tipoClienteRepository;
    }

    @GetMapping
    public List<TipoCliente> getAllTipoCliente() {
        return tipoClienteRepository.findAll();
    }

    @PostMapping
    public TipoCliente addTipoCliente(
            @RequestBody TipoClienteCreate tipoClienteCreate
    ) {
        TipoCliente tipoCliente = new TipoCliente(
                tipoClienteCreate.getNumeroTipoCliente(),
                tipoClienteCreate.getDescripcion(),
                tipoClienteCreate.getFechaRegistro()
        );

        return tipoClienteRepository.save(tipoCliente);
    }
}

