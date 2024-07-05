package com.forumhub.domain.user;

import jakarta.validation.constraints.NotNull;

public record DataUpdateUser(

        @NotNull
        Long id,
        @NotNull
        String login,
        @NotNull
        String senha
) {
}
