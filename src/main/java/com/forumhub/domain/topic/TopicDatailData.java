package com.forumhub.domain.topic;

import java.util.Date;

public record TopicDatailData(Long id, String titulo, String mensagem, Date dataCriacao, String autor, String curso, String respostas) {

    public TopicDatailData(Topic topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor(), topico.getCurso(), topico.getRespostas());
    }
}