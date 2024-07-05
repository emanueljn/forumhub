package com.forumhub.domain.user;

public record DataListUser(String login, String senha) {
    public DataListUser(User usuario) {
        this(usuario.getLogin(), usuario.getSenha());
    }
}