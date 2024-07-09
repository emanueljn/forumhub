package com.forumhub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataRecordTopic(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        Long idAutor,
        @NotBlank //@Valid
        String curso
) {
}
