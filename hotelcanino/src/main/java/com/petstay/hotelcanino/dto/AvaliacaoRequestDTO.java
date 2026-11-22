package com.petstay.hotelcanino.dto;

import jakarta.validation.constraints.*;

public record AvaliacaoRequestDTO(
    @NotBlank(message = "O nome do tutor é obrigatório")
    @Size(max = 120)
    String tutor,

    @NotBlank(message = "O nome e raça do pet são obrigatórios")
    @Size(max = 120)
    String pet,

    @NotBlank(message = "O serviço é obrigatório")
    @Size(max = 120)
    String servico,

    @NotNull(message = "A nota é obrigatória")
    @Min(value = 1, message = "A nota mínima é 1")
    @Max(value = 5, message = "A nota máxima é 5")
    Integer nota,

    @NotBlank(message = "O comentário é obrigatório")
    @Size(max = 2000)
    String comentario
) {}