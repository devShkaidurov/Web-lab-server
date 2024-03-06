package com.study.first_lab.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.study.first_lab.models.Project;

@Repository
public interface IProjectDAO extends JpaRepository<Project, Long> {

    // findByNameProjectIsContainingIgnoreCaseOrDescriptionProjectIsContainingIgnoreCase
    @Meta (comment = "Ищем вхождение строки pattern в имя или в описание проекта без учета регистра")
    List<Project> findByNameProjectIsContainingIgnoreCaseOrDescriptionProjectIsContainingIgnoreCase(String pattern0, String pattern1);
    
    @Query("SELECT p.id, (SELECT COUNT(t) FROM Task t WHERE t.isCompleted = False AND p.id = t.project.id) FROM Project p")
    public List<Object[]> findProjectsAndTaskCount();
}
