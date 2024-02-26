package com.study.first_lab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.study.first_lab.pojo.TaskPojo;
import com.study.first_lab.dao.ITaskDAO;
import com.study.first_lab.models.Project;
import com.study.first_lab.models.Task;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final ITaskDAO taskDAO;

    public List<TaskPojo> getAllTasks (long projectId) {
        List<Task> tasks = taskDAO.findAllByNameTask("выполнить задачу #1");
        List<TaskPojo> taskPojos = new ArrayList<>(tasks.size());
        for (Task task : tasks) 
            taskPojos.add(TaskPojo.fromEntity(task));
        return taskPojos;
    }

    public TaskPojo getTaskById (long projectId, long taskId) {
        return null;
    }
    
    public TaskPojo createTaskForProject (long projectId) {
        return null;
    }

    public TaskPojo deleteTaskById (long projectId, long taskId) {
        return null;
    }
}   
