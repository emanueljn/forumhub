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
//
//@RestController
//@RequestMapping("respostas")
//public class ResponseController {
//
//    @Autowired
//    private TopicRepository repository;
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity<DataDetailTopic> cadastrar(@RequestBody @Valid DataRecordTopic dados, UriComponentsBuilder uriBilder) {
//        var topico = new Topic(dados);
//        repository.save(topico);
//
//        var uri = uriBilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
//
//        return ResponseEntity.created(uri).body(new DataDetailTopic(topico));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity detalhar(@PathVariable Long id) {
//        var topico = repository.getReferenceById(id);
//
//        return ResponseEntity.ok(new DataDetailTopic(topico));
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<DataListTopic>> listar(
//            @PageableDefault(size = 10, sort = {"dataCriacao"}, direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable paginacao,
//            @RequestParam(value = "curso", required = false) String curso) {
//
//        Page<DataListTopic> page;
//
//        if (curso != null) {
//            page = repository.findByCurso(curso, paginacao).map(DataListTopic::new);
//        } else {
//            page = repository.findAll(paginacao).map(DataListTopic::new);
//        }
//
//        return ResponseEntity.ok(page);
//    }
//
//    @PutMapping("/{id}")
//    @Transactional
//    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DataUpdateTopic dados) {
//        Optional<Topic> optionalTopic = repository.findById(id);
//
//        if (optionalTopic.isPresent()) {
//            Topic topic = optionalTopic.get();
//            topic.atualizarInformacoes(dados);
//            repository.save(topic);
//            return ResponseEntity.ok(new DataDetailTopic(topic));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity excluir(@PathVariable Long id) {
//        Optional<Topic> optionalTopic = repository.findById(id);
//
//        if (optionalTopic.isPresent()) {
//        repository.deleteById(id);}
//
//        return ResponseEntity.noContent().build();
//    }
//}
