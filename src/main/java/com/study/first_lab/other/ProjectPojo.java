package com.study.first_lab.other;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectPojo {
    private String nameProject;
    private String descriptionProject;
    private Date startDateTime;
    private Date finishDateTime;

    public static ProjectPojo fromEntity (Project project) {
        ProjectPojo pojo = new ProjectPojo();
        pojo.setDescriptionProject(project.getDescriptionProject());
        pojo.setFinishDateTime(project.getFinishDateTime());
        pojo.setNameProject(project.getNameProject());
        pojo.setStartDateTime(project.getStartDateTime());
        return pojo;
    }

    public static Project toEntity (ProjectPojo pojo) {
        Project project = new Project();
        project.setDescriptionProject(pojo.getDescriptionProject());
        project.setNameProject(pojo.getNameProject());
        project.setStartDateTime(pojo.getStartDateTime());
        project.setFinishDateTime(pojo.getFinishDateTime());
        return project;
    }
}
