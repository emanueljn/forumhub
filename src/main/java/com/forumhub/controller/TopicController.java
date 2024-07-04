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

import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicController {

    @Autowired
    private TopicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDetailData> cadastrar(@RequestBody @Valid TopicRecordData dados, UriComponentsBuilder uriBilder) {
        var topico = new Topic(dados);
        repository.save(topico);

        var uri = uriBilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicDetailData(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new TopicDetailData(topico));
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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DataUpdateTopic dados) {
        Optional<Topic> optionalTopic = repository.findById(id);

        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topic.atualizarInformacoes(dados);
            repository.save(topic);
            return ResponseEntity.ok(new TopicDetailData(topic));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Optional<Topic> optionalTopic = repository.findById(id);

        if (optionalTopic.isPresent()) {
        repository.deleteById(id);}

        return ResponseEntity.noContent().build();
    }
}
