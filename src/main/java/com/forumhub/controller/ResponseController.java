package com.forumhub.controller;

import com.forumhub.domain.response.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("respostas")
public class ResponseController {

    @Autowired
    private ResponseRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DataDetailResponse> cadastrar(@RequestBody @Valid DataRecordResponse dados, UriComponentsBuilder uriBilder) {
        System.out.println(dados);

        var resposta = new Response();
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