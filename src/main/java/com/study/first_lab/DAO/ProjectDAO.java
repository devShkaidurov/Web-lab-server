package com.study.first_lab.DAO;

import java.sql.Date;

import com.study.first_lab.Other.Project;

public interface ProjectDAO {
    public int createProject();

    public int modifyProject(String nameProject);

    public int deleteProject(String nameProject);

    public Project getProject(String nameProject);

    public Project[] getProjectsWithFilter(Date startTime, Date finishTime);
}
