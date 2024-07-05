package com.forumhub.domain.user;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


public record DataRecordUser(

        @NotBlank
        String login,
        @NotBlank
        String senha
) {
}
