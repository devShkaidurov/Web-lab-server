package com.study.first_lab.pojo;

import java.util.Date;

import com.study.first_lab.models.Project;
import com.study.first_lab.models.Task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskPojo {
    private long taskId;
    private Project project;
    private String nameTask;
    private String descriptionTask;
    private Date plannedFinishDate;
    private boolean isCompleted;

    public static TaskPojo fromEntity (Task task) {
        TaskPojo pojo = new TaskPojo();
        pojo.setTaskId(task.getTaskId());
        pojo.setProject(task.getProject());
        pojo.setNameTask(task.getNameTask());
        pojo.setDescriptionTask(task.getDescriptionTask());
        pojo.setPlannedFinishDate(task.getPlannedFinishDate());
        pojo.setCompleted(task.isCompleted());
        return pojo;
    }

    public static Task toEntity (TaskPojo pojo) {
        Task task = new Task();
        task.setTaskId(pojo.getTaskId());
        task.setProject(pojo.getProject());
        task.setNameTask(pojo.getNameTask());
        task.setDescriptionTask(pojo.getDescriptionTask());
        task.setPlannedFinishDate(pojo.getPlannedFinishDate());
        task.setCompleted(pojo.isCompleted());
        return task;
    }
}
