package com.forumhub.domain.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private Date dataCriacao;
    private String autor;
    private String curso;
    private String respostas;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Topic(TopicRecordData dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.dataCriacao = Date.from(dados.dataCriacao());
        this.status = dados.status();
    }

    public void atualizarInformacoes(DataUpdateTopic dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.titulo = dados.mensagem();
        }
        if (dados.autor() != null) {
            this.titulo = dados.autor();
        }
        if (dados.curso() != null) {
            this.titulo = dados.curso();
        }
    }
}
