package com.forumhub.controller;

import com.forumhub.domain.topic.Topic;
import com.forumhub.domain.topic.TopicDatailData;
import com.forumhub.domain.topic.TopicRecordData;
import com.forumhub.domain.topic.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicController {

    @Autowired
    private TopicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid TopicRecordData dados, UriComponentsBuilder uriBilder) {
        var topico = new Topic(dados);
        repository.save(topico);

        var uri = uriBilder.path("/topic/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicDatailData(topico));
    }


}
