package com.forumhub.domain.topic;

import com.forumhub.domain.response.Response;
import com.forumhub.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    private String curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private User idUsuario;

    @OneToMany(mappedBy = "idTopico", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Response> resposta = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Status status;

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
