package com.study.first_lab.models;

import lombok.Data;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "projects", 
        schema = "public")
@Data
public class Project {
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String nameProject;
    @Column
    private String descriptionProject;

    @Column
    private Date   startDate;
    
    @Column
    private Date   finishDate;
    
    @OneToMany(mappedBy = "project", 
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Task> tasks;
}
