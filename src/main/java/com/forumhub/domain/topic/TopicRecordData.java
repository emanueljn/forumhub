package com.forumhub.domain.topic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


public record TopicRecordData(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor,
        @NotBlank @Valid
        String curso
) {
}
