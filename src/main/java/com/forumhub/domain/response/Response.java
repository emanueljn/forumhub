package com.forumhub.domain.response;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "respostas")
@Entity(name = "Response")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topico_id")
    private Long topico;

    @Column(name = "usuario_id")
    private Long autor;

    private String mensagem;

    private String solucao;

    private Date dataCriacao;

    public Response(DataRecordResponse dados, TopicService topicService) {
        this.topico = dados.topico();
        this.autor = dados.autor();
        this.solucao = dados.solucao();
        this.dataCriacao = Date.from(dados.dataCriacao());
    }

    public void atualizarInformacoes(DataUpdateResponse dados) {
        if (dados.solucao() != null) {
            this.solucao = dados.solucao();
        }
    }
}
