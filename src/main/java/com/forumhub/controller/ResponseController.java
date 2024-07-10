package com.forumhub.controller;

import com.forumhub.domain.response.*;
import com.forumhub.domain.topic.TopicRepository;
import com.forumhub.domain.user.UserRepository;
import com.forumhub.infra.exception.ValidacaoException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@RestController
@RequestMapping("respostas")
@SecurityRequirement(name = "bearer-key")
public class ResponseController {

    @Autowired
    private ResponseRepository repository;


    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DataDetailResponse> cadastrar(@RequestBody @Valid DataRecordResponse dados, UriComponentsBuilder uriBilder) {

        if(!topicRepository.existsById(dados.idTopico()) && !userRepository.existsById(dados.idAutor())) {
            throw new ValidacaoException("Id do tópico e id do usuário informados não existem!");
        }

        if(!topicRepository.existsById(dados.idTopico())) {
            throw new ValidacaoException("Id do tópico informado não existe!");
        }

        if(!userRepository.existsById(dados.idAutor())) {
            throw new ValidacaoException("Id do usuário informado não existe!");
        }

        LocalDateTime dataCriacao = LocalDateTime.now();
        var topico = topicRepository.findById(dados.idTopico()).get();

        var idTopico = topicRepository.getReferenceById(dados.idTopico());
        var idUsuario = userRepository.getReferenceById(dados.idAutor());


        var resposta = new Response(null, idTopico, idUsuario, topico.getMensagem(), dados.solucao(), dataCriacao);
        repository.save(resposta);

        var uri = uriBilder.path("/resposta/{id}").buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailResponse(resposta));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var resposta = repository.getReferenceById(id);

        return ResponseEntity.ok(new DataDetailResponse(resposta));
    }

    @GetMapping
    public ResponseEntity<Page<DataListResponse>> listar(
            @PageableDefault(size = 10, sort = {"dataCriacao"}, direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable paginacao,
            @RequestParam(value = "curso", required = false) String curso) {

        Page<DataListResponse> page = repository.findAll(paginacao).map(DataListResponse::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DataUpdateResponse dados) {
        var resposta = repository.getReferenceById(dados.id());
        resposta.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DataDetailResponse(resposta));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}