package com.forumhub.controller;

import com.forumhub.domain.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DataDetailUser> cadastrar(@RequestBody @Valid DataRecordUser dados, UriComponentsBuilder uriBilder) {
        var usuario = new User(dados);
        repository.save(usuario);

        var uri = uriBilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailUser(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);

        return ResponseEntity.ok(new DataDetailUser(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DataListUser>> listar(
            @PageableDefault(size = 10) Pageable paginacao) {

        Page<DataListUser> page = repository.findAll(paginacao).map(DataListUser::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DataUpdateUser dados) {
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {
            User usuario = optionalUser.get();
            usuario.atualizarInformacoes(dados);
            repository.save(usuario);
            return ResponseEntity.ok(new DataDetailUser(usuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {
        repository.deleteById(id);}

        return ResponseEntity.noContent().build();
    }
}
