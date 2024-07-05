package com.forumhub.domain.user;

public record DataDetailUser(Long id, String login, String senha) {

    public DataDetailUser(User usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getSenha());
    }
}