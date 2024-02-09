package com.study.first_lab.DAO;

import java.sql.Date;

import com.study.first_lab.Other.Project;

public class ProjectDAOImpl implements ProjectDAO {
    public int createProject() {
        return 200;
    }

    public int modifyProject(String nameProject) {
        return 200;
    }

    public int deleteProject(String nameProject) {
        return 200;
    }

    public Project getProject(String nameProject) {
        return new Project();
    }

    public Project[] getProjectsWithFilter(Date startTime, Date finishTime) {
        Project[] resultList = new Project[10];
        return resultList;
    }
}
