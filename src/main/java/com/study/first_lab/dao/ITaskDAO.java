package com.study.first_lab.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.study.first_lab.models.Task;
import jakarta.transaction.Transactional;

@Repository
public interface ITaskDAO extends JpaRepository<Task, Long> {
    public List<Task> findByProjectId(long id);

    public void deleteAllByProjectIdAndIsCompletedTrue(long projectId);

    public void deleteAllByProjectId(long projectId);

    public Task findByIdAndProjectId(long id, long projectId);

    @Transactional
    public void deleteByIdAndProjectId(long id, long projectId);
}
