package com.study.first_lab.service;

import org.springframework.stereotype.Service;

import com.study.first_lab.dao.IProjectDAO;
import com.study.first_lab.models.Project;
import com.study.first_lab.pojo.ProjectPojo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService { 
    private final IProjectDAO projectDAO;

    public ProjectPojo getProjectByDescFilter (String phrase) {
        return null;
    }

    public ProjectPojo getProjectById (long projectId) {
        Project project = projectDAO.findById(projectId);
        return ProjectPojo.fromEntity(project);
    }

    public ProjectPojo createProject (ProjectPojo project) {
        return null;
    }

    // don't update tasks
    public ProjectPojo updateProjectById (long projectId, ProjectPojo projectPojo) {
        return null;
    }

    public ProjectPojo deleteProjectById (long projectId) {
        return null;
    }

    
}