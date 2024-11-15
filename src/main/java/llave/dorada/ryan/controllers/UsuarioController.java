package llave.dorada.ryan.controllers;

import llave.dorada.ryan.dtos.UsuarioCreate;
import llave.dorada.ryan.entities.TipoUsuario;
import llave.dorada.ryan.entities.Usuario;
import llave.dorada.ryan.repositories.TipoUsuarioRepository;
import llave.dorada.ryan.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository, TipoUsuarioRepository tipoUsuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }


    @PostMapping(path = "/agregar")
    public Usuario addUsuario(
            @RequestBody UsuarioCreate usuarioCreate
    ) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(usuarioCreate.getTipoUsuario()).orElseThrow();
        return usuarioRepository.save(new Usuario(0, usuarioCreate.getNombre(), usuarioCreate.getApellidoPaterno(), usuarioCreate.getApellidoMaterno(), usuarioCreate.getFechaRegistro(), tipoUsuario));

    }

    @PutMapping("/actualizar/{id}")
    public Usuario updateUsuario(@PathVariable int id, @RequestBody UsuarioCreate usuarioCreate) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(usuarioCreate.getTipoUsuario()).orElseThrow();

        usuario.setNombre(usuarioCreate.getNombre());
        usuario.setApellidoPaterno(usuarioCreate.getApellidoPaterno());
        usuario.setApellidoMaterno(usuarioCreate.getApellidoMaterno());
        usuario.setFechaRegistro(usuarioCreate.getFechaRegistro());
        usuario.setTipoUsuario(tipoUsuario);

        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public List<Usuario> deleteUsuario(@PathVariable int id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuarioRepository.delete(usuario);
        return usuarioRepository.findAll();
    }


}
