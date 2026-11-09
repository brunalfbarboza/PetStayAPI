package com.petstay.hotelcanino.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
public record AgendamentoDTO(
        Long usuarioId,
        Long petId,
        LocalDate dataAgendamento,
        LocalDate dataDevolucao
) {
}
