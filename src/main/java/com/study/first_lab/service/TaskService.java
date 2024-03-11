package com.study.first_lab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import com.study.first_lab.dao.IProjectDAO;
import com.study.first_lab.dao.ITaskDAO;
import com.study.first_lab.dto.TaskDto;
import com.study.first_lab.dto.TaskPojo;
import com.study.first_lab.models.Project;
import com.study.first_lab.models.Task;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final ITaskDAO taskDAO;
    private final IProjectDAO projectDAO;

    public List<TaskPojo> getAllTasks (long projectId) {
        List<Task> tasks = taskDAO.findByProjectId(projectId);
        List<TaskPojo> taskPojos = new ArrayList<>(tasks.size());
        for (Task task : tasks) 
            taskPojos.add(TaskPojo.fromEntity(task));
        return taskPojos;
    }

    public TaskPojo getTaskById (long projectId, long taskId) {
        try {
            Task returnedTask = taskDAO.findByIdAndProjectId (taskId, projectId);
            return TaskPojo.fromEntity(returnedTask);
        } catch (NullPointerException ex) {
            return null;
        }
    }
    
    public TaskDto createTaskForProject (long projectId, TaskDto taskDto) {
        Task task = TaskDto.toEntity(taskDto);
        Project project = projectDAO.findById(projectId).get();
        task.setProject(project);
        taskDAO.save(task);
        return taskDto;
    }

    public TaskDto updateTaskByProjectId (long projectId, long taskId, TaskDto taskDto) {
        try {
            Task returnedTask = taskDAO.findByIdAndProjectId (taskId, projectId);
            returnedTask.setCompleted(taskDto.isCompleted());
            returnedTask.setDescriptionTask(taskDto.getDescriptionTask());
            returnedTask.setNameTask(taskDto.getNameTask());
            returnedTask.setPlannedFinishDate(taskDto.getPlannedFinishDate());
            taskDAO.save(returnedTask);
            return taskDto;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    // TODO: спросить
    @Transactional
    public void deleteTaskById (long projectId, long taskId) {
        taskDAO.deleteByIdAndProjectId(taskId, projectId);
    }

    @Transactional
    public void deleteCompletedTaskByProjectId (long projectId) {
        taskDAO.deleteAllByProjectIdAndIsCompletedTrue(projectId);
    }
}   
