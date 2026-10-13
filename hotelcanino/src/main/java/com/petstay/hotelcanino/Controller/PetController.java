package com.petstay.hotelcanino.Controller;

import com.petstay.hotelcanino.Model.Pet;
import com.petstay.hotelcanino.Model.Usuario;
import com.petstay.hotelcanino.Repository.PetRepository;
import com.petstay.hotelcanino.Repository.UsuarioRepository;
import com.petstay.hotelcanino.Service.PetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PetController {

    private final PetRepository repository;
    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public Pet cadastrarPet (@RequestBody PetDTO petDTO){

        Pet pet = new Pet();
        pet.setNome(petDTO.nome());
        pet.setRaca(petDTO.raca());

       Usuario usuario = usuarioRepository.findById(petDTO.usuarioId()).orElseThrow(
               () -> new RuntimeException("Usuário não encontrado")
       );

        usuario.addPet(pet);
        return repository.save(pet);
    }
}
