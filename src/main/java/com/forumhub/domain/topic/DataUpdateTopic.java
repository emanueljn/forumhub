package com.forumhub.domain.topic;

import jakarta.validation.constraints.NotNull;

public record DataUpdateTopic(

        @NotNull
        Long id,
        String titulo,
        String mensagem,
        String autor,
        String curso
) {
}
