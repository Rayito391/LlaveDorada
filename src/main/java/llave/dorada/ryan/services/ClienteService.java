package llave.dorada.ryan.services;

import llave.dorada.ryan.entities.Cliente;
import llave.dorada.ryan.entities.TipoCliente;
import llave.dorada.ryan.entities.Venta;
import llave.dorada.ryan.repositories.ClienteRepository;
import llave.dorada.ryan.repositories.TipoClienteRepository;
import llave.dorada.ryan.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final TipoClienteRepository tipoClienteRepository;
    private final VentaRepository ventaRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, TipoClienteRepository tipoClienteRepository, VentaRepository ventaRepository) {
        this.clienteRepository = clienteRepository;
        this.tipoClienteRepository = tipoClienteRepository;
        this.ventaRepository = ventaRepository;
    }

    public double calcularDescuento(int numeroCliente, double total) {
        Cliente cliente = clienteRepository.findById(numeroCliente).orElseThrow();

        double descuento = 0.0;

        switch (cliente.getTipoCliente().getNumeroTipoCliente()) {
            case 2:
                descuento = 0.05;
                break;
            case 3:
                descuento = 0.08;
                break;
            default:
                descuento = 0.0;
                break;
        }
        double totalConDescuento = total - (total * descuento);
        return totalConDescuento;
    }

    public void actualizarTipoCliente(int numeroCliente) {
        Cliente cliente = clienteRepository.findById(numeroCliente).orElseThrow();

        LocalDate unAnioAtras = LocalDate.now().minusYears(1);
        List<Venta> ventasUltimoAnio = ventaRepository.findVentasByClienteAndFechaVentaAfter(cliente, unAnioAtras);

        double totalCompras = ventasUltimoAnio.stream().mapToDouble(Venta::getTotal).sum();

        if (totalCompras > 1500) {
            TipoCliente tipoCliente = tipoClienteRepository.findByDescripcion("Premium");
            cliente.setTipoCliente(tipoCliente);
        } else if (totalCompras > 500) {
            TipoCliente tipoCliente = tipoClienteRepository.findByDescripcion("Avanzado");
            cliente.setTipoCliente(tipoCliente);
        }

        clienteRepository.save(cliente);
    }
}
