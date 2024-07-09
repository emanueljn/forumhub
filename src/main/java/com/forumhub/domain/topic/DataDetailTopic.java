package com.forumhub.domain.topic;

import com.forumhub.domain.response.Response;

import java.time.LocalDateTime;

public record DataDetailTopic(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Long idAutor, String curso, java.util.Set<Response> respostas, Status status) {

    public DataDetailTopic(Topic topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getIdUsuario().getId(), topico.getCurso(), topico.getResposta(), topico.getStatus());
    }
}