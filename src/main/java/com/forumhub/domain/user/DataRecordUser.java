package com.forumhub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record DataRecordUser(

        @NotBlank(message = "Email do usuário é obrigatório")
        String login,

        @NotBlank(message = "Senha do usuário  é obrigatória")
        String senha
) {
}
