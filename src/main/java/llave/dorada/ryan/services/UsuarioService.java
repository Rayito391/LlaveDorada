package llave.dorada.ryan.services;

import llave.dorada.ryan.entities.Usuario;
import llave.dorada.ryan.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void verTipoUsuario(int numeroTipoUsuario) {
        Usuario usuario = usuarioRepository.findById(numeroTipoUsuario).orElseThrow();

    }
}
