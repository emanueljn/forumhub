package com.forumhub.controller;

import com.forumhub.domain.topic.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("topicos")
public class TopicController {

    @Autowired
    private TopicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDatailData> cadastrar(@RequestBody @Valid TopicRecordData dados, UriComponentsBuilder uriBilder) {
        var topico = new Topic(dados);
        repository.save(topico);

        var uri = uriBilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicDatailData(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new TopicDatailData(topico));
    }

    @GetMapping
    public ResponseEntity<Page<ListTopicData>> listar(
            @PageableDefault(size = 10, sort = {"dataCriacao"}, direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable paginacao,
            @RequestParam(value = "curso", required = false) String curso) {

        Page<ListTopicData> page;

        if (curso != null) {
            page = repository.findByCurso(curso, paginacao).map(ListTopicData::new);
        } else {
            page = repository.findAll(paginacao).map(ListTopicData::new);
        }

        return ResponseEntity.ok(page);
    }
}

