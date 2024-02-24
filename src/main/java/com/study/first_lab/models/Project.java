package com.study.first_lab.models;

import lombok.Data;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "project", schema = "public")
@Data
public class Project {
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long projectId;

    @Column
    private String nameProject;
    @Column
    private String descriptionProject;

    @Column
    private Date   startDate;
    
    @Column
    private Date   finishDate;
    
    @OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;
}
