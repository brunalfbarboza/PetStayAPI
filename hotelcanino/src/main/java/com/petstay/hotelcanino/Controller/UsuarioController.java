package com.petstay.hotelcanino.Controller;

import com.petstay.hotelcanino.dto.LoginDTO;
import com.petstay.hotelcanino.Model.Usuario;
import com.petstay.hotelcanino.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    private final UsuarioRepository repository;

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PostMapping("/login")
    public Usuario Login(@RequestBody LoginDTO  loginDTO) {
        Usuario usuario = repository.findByEmail(loginDTO.email());

        if (usuario == null) {
            throw new RuntimeException("E-mail ou senha inválidos");
        }

        if (!loginDTO.senha().equals(usuario.getSenha())) {
            throw new RuntimeException("não foi possivel fazer login");
        }

        return usuario;
    }
}