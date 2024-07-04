package com.forumhub.domain.topic;

import java.util.Date;

public record ListTopicData(String titulo, String mensagem, Date dataCriacao, Status status, String autor, String curso) {

    public ListTopicData(Topic topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}