package com.study.first_lab.models;

import lombok.Data;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "project", 
        schema = "public")
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
    
    @OneToMany(mappedBy = "project", 
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Task> tasks;
}
