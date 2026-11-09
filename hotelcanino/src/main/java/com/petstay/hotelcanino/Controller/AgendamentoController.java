package com.petstay.hotelcanino.Controller;

import com.petstay.hotelcanino.Model.Agendamento;
import com.petstay.hotelcanino.Model.Pet;
import com.petstay.hotelcanino.Model.Usuario;
import com.petstay.hotelcanino.Repository.AgendamentoRepository;
import com.petstay.hotelcanino.Repository.PetRepository;
import com.petstay.hotelcanino.Repository.UsuarioRepository;
import com.petstay.hotelcanino.dto.AgendamentoDTO;
import com.petstay.hotelcanino.dto.AgendamentoResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AgendamentoController {

    private final PetRepository petRepository;

    private final UsuarioRepository  usuarioRepository;

    private final AgendamentoRepository agendamentoRepository;

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamento(@RequestBody AgendamentoDTO agendamentoDTO) {

        Usuario usuario = usuarioRepository.findById(agendamentoDTO.usuarioId())
                .orElseThrow(() -> new EntityNotFoundException("usuario não encontrado"));

        Pet pet = petRepository.findById(agendamentoDTO.petId())
                .orElseThrow(() -> new EntityNotFoundException("pet não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setUsuario(usuario);
        agendamento.setPet(pet);
        agendamento.setDataAgendamento(agendamentoDTO.dataAgendamento());
        agendamento.setDataDevolucao(agendamentoDTO.dataDevolucao());

        agendamentoRepository.save(agendamento);

        AgendamentoResponseDTO responseDTO = AgendamentoResponseDTO.fromEntity(agendamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    };
}
