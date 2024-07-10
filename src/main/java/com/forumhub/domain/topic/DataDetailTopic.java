package com.forumhub.domain.topic;

import com.forumhub.domain.response.Response;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public record DataDetailTopic(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Long idAutor, String curso, java.util.Set<SimpleResponse> respostas, Status status) {

    public DataDetailTopic(Topic topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getIdUsuario().getId(), topico.getCurso(), topico.getResposta() != null ? topico.getResposta().stream().map(SimpleResponse::new).collect(Collectors.toSet()) : null, topico.getStatus());
    }

    public record SimpleResponse(Long id, String mensagem, LocalDateTime dataCriacao, Long idAutor) {
        public SimpleResponse(Response response) {
            this(response.getId(), response.getMensagem(), response.getDataCriacao(), response.getIdUsuario().getId());
        }
    }
}