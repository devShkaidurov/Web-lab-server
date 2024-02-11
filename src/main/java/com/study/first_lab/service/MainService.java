package com.study.first_lab.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.first_lab.dao.ProjectDAOImpl;
import com.study.first_lab.other.Project;
import com.study.first_lab.other.ProjectPojo;

@Service
public class MainService {

    @Autowired
    private ProjectDAOImpl projectDAO;

    public ProjectPojo getProjectByName(String nameProject) {
        Project project = projectDAO.getProject(nameProject);
        if (project != null)
            return ProjectPojo.fromEntity(project);
        else 
            return null;
    }
    
    public boolean createProject(ProjectPojo pojo) {
        Project project = ProjectPojo.toEntity(pojo);
        return projectDAO.createProject(project);
    }

    public int updateProject (String name, ProjectPojo pojo) {
        Project project = ProjectPojo.toEntity(pojo);
        return projectDAO.modifyProject(name, project);
    }

    public void deleteProjectByName (String projectName) {
        projectDAO.deleteProject(projectName);
    }

    public List<ProjectPojo> getProjectsWithFilter (LocalDateTime start, LocalDateTime finish) {
        List<Project> resultList = projectDAO.getProjectsWithFilter(start, finish);
        List<ProjectPojo> convertedList = new ArrayList<>(resultList.size());
        for (int i = 0; i < resultList.size(); i++) 
            convertedList.add(ProjectPojo.fromEntity(resultList.get(i)));
        return convertedList;
    }

    public List<ProjectPojo> getAllProjects () {
        List<Project> resultList = projectDAO.getAllProjects();
        List<ProjectPojo> convertedList = new ArrayList<>(resultList.size());
        for (int i = 0; i < resultList.size(); i++) 
            convertedList.add(ProjectPojo.fromEntity(resultList.get(i)));
        return convertedList;
    }
}
