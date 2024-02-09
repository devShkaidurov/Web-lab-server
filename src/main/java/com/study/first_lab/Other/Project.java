package com.study.first_lab.Other;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {
    private String nameProject;
    private String descriptionProject;
    private Date startDateTime;
    private Date finishDateTime;
}
