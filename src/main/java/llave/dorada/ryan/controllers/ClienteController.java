package llave.dorada.ryan.controllers;


import llave.dorada.ryan.dtos.ClienteCreate;
import llave.dorada.ryan.entities.Cliente;
import llave.dorada.ryan.entities.TipoCliente;
import llave.dorada.ryan.repositories.ClienteRepository;
import llave.dorada.ryan.repositories.TipoClienteRepository;
import llave.dorada.ryan.repositories.VentaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
    private final ClienteRepository clienteRepository;
    private final VentaRepository ventaRepository;
    private final TipoClienteRepository tipoClienteRepository;

    public ClienteController(ClienteRepository clienteRepository, TipoClienteRepository tipoClienteRepository, VentaRepository ventaRepository) {
        this.clienteRepository = clienteRepository;
        this.tipoClienteRepository = tipoClienteRepository;
        this.ventaRepository = ventaRepository;
    }

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping(path = "/agregar")
    public Cliente addCliente(
            @RequestBody ClienteCreate clienteCreate
    ) {
        TipoCliente tipoCliente = tipoClienteRepository.findById(clienteCreate.getTipoCliente()).orElseThrow();
        return clienteRepository.save(new Cliente(0, clienteCreate.getNombre(), clienteCreate.getApellidoPaterno(), clienteCreate.getApellidoMaterno(), clienteCreate.getFechaNacimiento(), clienteCreate.getDomicilio(), clienteCreate.getFechaRegistro(), tipoCliente, List.of()));
    }

    @PutMapping("/actualizar/{id}")
    public Cliente updateCliente(@PathVariable int id, @RequestBody ClienteCreate clienteCreate) {

        Cliente cliente = clienteRepository.findById(id).orElseThrow();

        TipoCliente tipoCliente = tipoClienteRepository.findById(clienteCreate.getTipoCliente()).orElseThrow();

        cliente.setNombre(clienteCreate.getNombre());
        cliente.setApellidoPaterno(clienteCreate.getApellidoPaterno());
        cliente.setApellidoMaterno(clienteCreate.getApellidoMaterno());
        cliente.setFechaNacimiento(clienteCreate.getFechaNacimiento());
        cliente.setDomicilio(clienteCreate.getDomicilio());
        cliente.setFechaRegistro(clienteCreate.getFechaRegistro());
        cliente.setTipoCliente(tipoCliente);

        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteCliente(@PathVariable int id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        clienteRepository.delete(cliente);
    }
}
