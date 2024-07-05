package com.forumhub.domain.user;

public record DataDetailUser(Long id, String nome, String login, String senha) {

    public DataDetailUser(User usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha());
    }
}