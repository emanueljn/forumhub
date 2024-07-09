package com.forumhub.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.forumhub.domain.topic.Topic;
import com.forumhub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respostas")
@Entity(name = "Response")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topic idTopico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private User idUsuario;

    private String mensagem;

    private String solucao;

    private LocalDateTime dataCriacao;

    public void atualizarInformacoes(DataUpdateResponse dados) {
        if (dados.solucao() != null) {
            this.solucao = dados.solucao();
        }
    }

    public LocalDateTime dataCriacao() {
        return LocalDateTime.now();
    }
}
