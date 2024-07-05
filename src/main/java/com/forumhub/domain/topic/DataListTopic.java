package com.forumhub.domain.topic;

import java.util.Date;

public record DataListTopic(String titulo, String mensagem, Date dataCriacao, Status status, String autor, String curso) {

    public DataListTopic(Topic topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}