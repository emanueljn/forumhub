package com.forumhub.domain.user;

public record DataListUser(Long id, String nomeUsuario, String login) {

    public DataListUser(User usuario) {
        this(usuario.getId(), usuario.getUsername(), usuario.getLogin());
    }
}