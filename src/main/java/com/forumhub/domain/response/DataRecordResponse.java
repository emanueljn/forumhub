package com.forumhub.domain.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


public record DataRecordResponse(
        @NotNull
        Long topico,
        @NotNull
        Long autor,
        @NotBlank
        String solucao
) {

        public Instant dataCriacao() {
                return LocalDateTime.now().toInstant(ZoneOffset.of("-03:00"));
        }
}