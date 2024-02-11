package com.study.first_lab.dao;

import java.time.LocalDateTime;
import java.util.List;
import com.study.first_lab.other.Project;

public interface ProjectDAO {
    public boolean createProject(Project project);

    public int modifyProject(String name, Project project);

    public void deleteProject(String nameProject);

    public Project getProject(String nameProject);

    public List<Project> getProjectsWithFilter(LocalDateTime startTime, LocalDateTime finishTime);

    public List<Project> getAllProjects();
}
