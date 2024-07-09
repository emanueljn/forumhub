package com.forumhub.domain.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRecordResponse(
        @NotNull
        Long idTopico,
        @NotNull
        Long idAutor,
        @NotBlank
        String solucao
) {
}