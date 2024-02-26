package com.study.first_lab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.first_lab.models.Project;

@Repository
public interface IProjectDAO extends JpaRepository<Project, Long> {
    public Project findById (long id);
}
