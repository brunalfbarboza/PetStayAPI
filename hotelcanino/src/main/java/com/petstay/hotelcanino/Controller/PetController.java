package com.petstay.hotelcanino.Controller;

import com.petstay.hotelcanino.Model.Pet;
import com.petstay.hotelcanino.Model.Usuario;
import com.petstay.hotelcanino.Repository.PetRepository;
import com.petstay.hotelcanino.Repository.UsuarioRepository;
import com.petstay.hotelcanino.dto.PetDTO;
import com.petstay.hotelcanino.dto.PetResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PetController {

    private final PetRepository repository;
    private final UsuarioRepository usuarioRepository;

    @GetMapping("/{usuarioId}")
    public List<PetResponseDTO> getPets(@PathVariable Long usuarioId) {
        List<Pet> pets = repository.findByUsuarioId(usuarioId);

        // Mapeia a Entidade para o DTO, cortando o loop infinito
        return pets.stream()
                .map(pet -> new PetResponseDTO(pet.getId(), pet.getNome(), pet.getRaca()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarPet(@RequestBody PetDTO petDTO) {
        Usuario usuario = usuarioRepository.findById(petDTO.usuarioId()).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );

        Pet pet = new Pet();
        pet.setNome(petDTO.nome());
        pet.setRaca(petDTO.raca());

        usuario.addPet(pet);
        repository.save(pet);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
