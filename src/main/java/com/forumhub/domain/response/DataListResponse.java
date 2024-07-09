package com.forumhub.domain.response;

import java.time.LocalDateTime;

public record DataListResponse(String mensagem, Long idTopico, Long idUsuario, LocalDateTime dataCriacao, String solucao) {

    public DataListResponse(Response resposta) {
        this(resposta.getMensagem(), resposta.getIdTopico().getId(), resposta.getIdUsuario().getId(), resposta.getDataCriacao(), resposta.getSolucao());
    }
}
