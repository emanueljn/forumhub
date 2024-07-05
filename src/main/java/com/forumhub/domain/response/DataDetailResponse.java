package com.forumhub.domain.response;

import java.util.Date;


public record DataDetailResponse(Long id, Long topico, String mensagem, String solucao, Date dataCriacao) {

    public DataDetailResponse(Response resposta) {
        this(resposta.getId(), resposta.getTopico(), resposta.getMensagem(), resposta.getSolucao(), resposta.getDataCriacao());
    }
}
