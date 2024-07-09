package com.forumhub.domain.topic;

import java.time.LocalDateTime;

public record DataListTopic(String titulo, String mensagem, LocalDateTime dataCriacao, Status status, Long idAutor, String curso) {

    public DataListTopic(Topic topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getIdUsuario().getId(), topico.getCurso());
    }
}