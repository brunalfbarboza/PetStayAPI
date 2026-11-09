package com.petstay.hotelcanino.dto;

import com.petstay.hotelcanino.Model.Agendamento;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgendamentoResponseDTO(
        Long id,
        LocalDate dataAgendamento,
        LocalDate dataCriacao,
        String nomePet,
        String nomeUsuario
) {
    public static AgendamentoResponseDTO fromEntity(Agendamento agendamento) {
        return new AgendamentoResponseDTO(
                agendamento.getId(),
                agendamento.getDataAgendamento(),
                agendamento.getDataCriacao(),
                agendamento.getPet() != null ? agendamento.getPet().getNome() : null,
                agendamento.getPet() != null && agendamento.getPet().getUsuario() != null
                        ? agendamento.getPet().getUsuario().getNome() : null
        );
    }
}