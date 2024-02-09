package com.study.first_lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.first_lab.dao.ProjectDAOImpl;
import com.study.first_lab.other.Project;

@Service
public class MainService {

    @Autowired
    private ProjectDAOImpl projectDAO;

    public Project getProjectByName(String nameProject) {
        return projectDAO.getProject(nameProject);
    }
}
