package com.study.first_lab.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import com.study.first_lab.models.Project;
@Setter
@Getter

public class ProjectPojo {
    private long   id;
    private String nameProject;
    private String descriptionProject;
    private Date   startDate;
    private Date   finishDate;

    public static ProjectPojo fromEntity (Project project) {
        ProjectPojo pojo = new ProjectPojo();
        pojo.setId(project.getId());
        pojo.setNameProject(project.getNameProject());
        pojo.setDescriptionProject(project.getDescriptionProject());
        pojo.setStartDate(project.getStartDate());
        pojo.setFinishDate(project.getFinishDate());
        return pojo;
    }

    public static Project toEntity (ProjectPojo pojo) {
        Project project = new Project();
        project.setId(pojo.getId());
        project.setNameProject(pojo.getNameProject());
        project.setDescriptionProject(pojo.getDescriptionProject());
        project.setStartDate(pojo.getStartDate());
        project.setFinishDate(pojo.getFinishDate());
        return project;
    }
}
