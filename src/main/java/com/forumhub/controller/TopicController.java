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

@RestController
@RequestMapping("topicos")
public class TopicController {

    @Autowired
    private TopicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDatailData> cadastrar(@RequestBody @Valid TopicRecordData dados, UriComponentsBuilder uriBilder) {
        System.out.println(dados);
        var topico = new Topic(dados);
        repository.save(topico);

        var uri = uriBilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicDatailData(topico));
    }
}

