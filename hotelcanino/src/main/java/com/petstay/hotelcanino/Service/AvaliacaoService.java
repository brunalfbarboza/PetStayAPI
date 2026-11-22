package com.petstay.hotelcanino.Service;

import com.petstay.hotelcanino.Model.Avaliacao;
import com.petstay.hotelcanino.Repository.AvaliacaoRepository;
import com.petstay.hotelcanino.dto.AvaliacaoRequestDTO;
import com.petstay.hotelcanino.dto.AvaliacaoResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;

    public AvaliacaoService(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public AvaliacaoResponseDTO criar(AvaliacaoRequestDTO request) {
        Avaliacao entity = new Avaliacao(
            request.tutor().trim(),
            request.pet().trim(),
            request.servico().trim(),
            request.nota(),
            request.comentario().trim()
        );

        Avaliacao salva = repository.save(entity);
        return AvaliacaoResponseDTO.fromEntity(salva);
    }

    @Transactional(readOnly = true)
    public List<AvaliacaoResponseDTO> listarRecentes() {
        return repository.findAllByOrderByCriadoEmDesc()
                .stream()
                .map(AvaliacaoResponseDTO::fromEntity)
                .toList();
    }
}