package com.forumhub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRecordTopic(

        @NotBlank(message = "Título do tópico é obrigatório")
        String titulo,

        @NotBlank(message = "Mensagem do usuário é obrigatório")
        String mensagem,

        @NotNull(message = "Id do autor do é obrigatório")
        Long idAutor,

        @NotBlank(message = "Curso é obrigatório")
        String curso
) {
}
