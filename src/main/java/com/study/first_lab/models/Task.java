package com.study.first_lab.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tasks", 
        schema="public")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id", 
        foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    @JsonManagedReference
    private Project project;
    @Column
    private String nameTask;
    @Column
    private String descriptionTask;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date plannedFinishDate;
    @Column
    private boolean isCompleted;
}
