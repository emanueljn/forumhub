package com.forumhub.domain.response;

import java.time.LocalDateTime;

public record DataDetailResponse(Long id, Long idTopico, Long idUsuario, String mensagem, String solucao, LocalDateTime dataCriacao) {

    public DataDetailResponse(Response resposta) {
        this(resposta.getId(), resposta.getIdTopico().getId(), resposta.getIdUsuario().getId(), resposta.getMensagem(), resposta.getSolucao(), resposta.getDataCriacao());
    }
}
