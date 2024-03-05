package com.study.first_lab.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study.first_lab.dao.IProjectDAO;
import com.study.first_lab.dao.ITaskDAO;
import com.study.first_lab.models.Project;
import com.study.first_lab.pojo.ProjectPojo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService { 
    private final IProjectDAO projectDAO;
    private final ITaskDAO taskDAO;

    public List<ProjectPojo> getProjectByDescFilter (String phrase) {
        List<Project> resultList = projectDAO.findByNameProjectIsContainingIgnoreCaseOrDescriptionProjectIsContainingIgnoreCase(phrase, phrase);
        List<ProjectPojo> listPojos = new ArrayList<>();
        for (int i = 0; i < resultList.size(); i++)
            listPojos.add(ProjectPojo.fromEntity(resultList.get(i)));
        return listPojos;
    }

    public ProjectPojo getProjectById (long projectId) {
        Project project = projectDAO.findById(projectId).get();
        return ProjectPojo.fromEntity(project);
    }

    public ProjectPojo createProject (ProjectPojo projectPojo) {
        Project project = ProjectPojo.toEntity(projectPojo);
        project.setTasks(null);
        return ProjectPojo.fromEntity(projectDAO.save(project));
    }

    public ProjectPojo updateProjectById (long projectId, ProjectPojo projectPojo) {
        Project project = ProjectPojo.toEntity(projectPojo);    // I think it's needn't
        Optional<Project> oldProject = projectDAO.findById(projectId);
        if (oldProject.isPresent()) {
            oldProject.get().setNameProject(project.getNameProject());
            oldProject.get().setDescriptionProject(project.getDescriptionProject());
            oldProject.get().setTasks(project.getTasks());
            oldProject.get().setFinishDate(project.getFinishDate());
            oldProject.get().setStartDate(project.getStartDate());
            projectDAO.save(oldProject.get());
            return ProjectPojo.fromEntity(oldProject.get());
        }
        return null;
    }

    public void deleteProjectById (long projectId) {
        projectDAO.deleteById(projectId);
        taskDAO.deleteAllByProjectId (projectId);
    }

    
}