package com.study.first_lab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.study.first_lab.models.Task;

// @Repository
public interface ITaskDAO extends JpaRepository<Task, Long> {
    public List<Task> findByProjectId(long id);
}
