package com.study.first_lab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.first_lab.pojo.TaskPojo;

@Service
public class TaskService {
    public List<TaskPojo> getAllTasks (long projectId) {
        return null;
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
