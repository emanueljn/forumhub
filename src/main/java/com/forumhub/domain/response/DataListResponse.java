package com.forumhub.domain.response;

import java.util.Date;

public record DataListResponse(String mensagem, Long topico, Date dataCriacao, Long autor, String solucao) {

    public DataListResponse(Response resposta) {
        this(resposta.getMensagem(), resposta.getTopico(), resposta.getDataCriacao(), resposta.getAutor(), resposta.getSolucao());
    }
}
