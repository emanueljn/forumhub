package com.forumhub.domain.user;

import com.forumhub.domain.perfil.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DataRecordUser(

        @NotBlank(message = "Nome do usuário é obrigatório")
        String nome,

        @NotBlank(message = "Email do usuário é obrigatório")
        @Email
        String login,

        @NotBlank(message = "Senha do usuário  é obrigatória")
        String senha,

        @NotNull(message = "Tipo de usuário é obrigatório")
        Tipo tipoDeUsuario
) {
}
