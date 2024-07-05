package com.forumhub.domain.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataUpdateResponse(

        @NotNull
        Long id,
        @NotBlank
        String solucao
) {
}

