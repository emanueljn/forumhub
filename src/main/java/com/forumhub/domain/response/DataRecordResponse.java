package com.forumhub.domain.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRecordResponse(

        @NotNull(message = "Id do tópico é obrigatório")
        Long idTopico,

        @NotNull(message = "Id do autor é obrigatório")
        Long idAutor,

        @NotBlank(message = "Solução é obrigatória")
        String solucao
) {
}