package com.study.first_lab.models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="task", schema="public")
@Data

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long taskId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Project projectId;
    
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
