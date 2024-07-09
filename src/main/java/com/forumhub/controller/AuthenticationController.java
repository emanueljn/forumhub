package com.forumhub.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.forumhub.domain.user.DataAuthentication;
import com.forumhub.domain.user.User;
import com.forumhub.infra.security.TokenJWTData;
import com.forumhub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DataAuthentication dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT =tokenService.gerarToken((User) authentication.getPrincipal());

            return ResponseEntity.ok(new TokenJWTData(tokenJWT));
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Ocorreu um erro: " + e.getMessage());
        }
    }
}
