package com.petstay.hotelcanino.dto;


import com.petstay.hotelcanino.Model.Avaliacao;

import java.time.LocalDateTime;

public record AvaliacaoResponseDTO(
    Long id,
    String tutor,
    String pet,
    String servico,
    Integer nota,
    String comentario,
    LocalDateTime criadoEm
) {
    public static AvaliacaoResponseDTO fromEntity(Avaliacao avaliacao) {
        return new AvaliacaoResponseDTO(
            avaliacao.getId(),
            avaliacao.getTutor(),
            avaliacao.getPet(),
            avaliacao.getServico(),
            avaliacao.getNota(),
            avaliacao.getComentario(),
            avaliacao.getCriadoEm()
        );
    }
}