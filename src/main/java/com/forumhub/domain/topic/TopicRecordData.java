package com.forumhub.domain.topic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


public record TopicRecordData(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
        public Instant dataCriacao() {
                return LocalDateTime.now().toInstant(ZoneOffset.of("-03:00"));
        }
}
