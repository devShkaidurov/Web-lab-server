package com.study.first_lab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.first_lab.models.Project;

@Repository
public interface IProjectDAO extends CrudRepository<Project, Long> {
    public Project findById (long id);
}
