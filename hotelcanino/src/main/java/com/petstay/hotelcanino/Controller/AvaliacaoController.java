package com.petstay.hotelcanino.Controller;

import com.petstay.hotelcanino.Service.AvaliacaoService;
import com.petstay.hotelcanino.dto.AvaliacaoRequestDTO;
import com.petstay.hotelcanino.dto.AvaliacaoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@CrossOrigin(origins = "http://localhost:5173")
public class AvaliacaoController {

    private final AvaliacaoService service;

    public AvaliacaoController(AvaliacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AvaliacaoResponseDTO> criar(@Valid @RequestBody AvaliacaoRequestDTO request) {
        AvaliacaoResponseDTO criada = service.criar(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(criada.id())
                .toUri();

        return ResponseEntity.created(location).body(criada);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarRecentes());
    }
}