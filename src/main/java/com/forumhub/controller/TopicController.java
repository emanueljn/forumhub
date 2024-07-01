package com.forumhub.controller;

import com.forumhub.domain.topic.Topic;
import com.forumhub.domain.topic.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicController {

    @Autowired
    private TopicRepository repository;




}
