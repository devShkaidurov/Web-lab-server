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
    private Project projectId;
    private String nameTask;
    private String descriptionTask;
    private Date plannedFinishDate;
    private boolean isCompleted;

    public static TaskPojo fromEntity (Task task) {
        TaskPojo pojo = new TaskPojo();
        pojo.setTaskId(task.getTaskId());
        pojo.setProjectId(task.getProjectId());
        pojo.setNameTask(task.getNameTask());
        pojo.setDescriptionTask(task.getDescriptionTask());
        pojo.setPlannedFinishDate(task.getPlannedFinishDate());
        pojo.setCompleted(task.isCompleted());
        return pojo;
    }

    public static Task toEntity (TaskPojo pojo) {
        Task task = new Task();
        task.setTaskId(pojo.getTaskId());
        task.setProjectId(pojo.getProjectId());
        task.setNameTask(pojo.getNameTask());
        task.setDescriptionTask(pojo.getDescriptionTask());
        task.setPlannedFinishDate(pojo.getPlannedFinishDate());
        task.setCompleted(pojo.isCompleted());
        return task;
    }
}
