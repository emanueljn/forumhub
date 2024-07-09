package com.forumhub.domain.topic;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findByCurso(String curso, Pageable paginacao);

    @Query("""
            select t from Topic t 
            where year(t.dataCriacao) = :ano
            """)
    Page<Topic> findByAnoDataCriacao(@Param("ano") int ano, Pageable paginacao);

    @Query("""
            select t from Topic t 
            where year(t.dataCriacao) = :ano 
            and
            t.curso = :curso
            """)
    Page<Topic> findByCursoAndAnoDataCriacao(String curso, Integer ano, Pageable paginacao);
}