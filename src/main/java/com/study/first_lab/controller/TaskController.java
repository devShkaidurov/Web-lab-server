package com.study.first_lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.first_lab.service.TaskService;

@RestController
@RequestMapping("/projects/{projectId}")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public ResponseEntity<?> getAllTasks (@PathVariable("projectId") long projectId) {
        return new ResponseEntity<>(taskService.getAllTasks(projectId), HttpStatus.OK);
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<?> getTaskById (@PathVariable("projectId") long projectId, 
        @PathVariable("taskId") long taskId) {
            return new ResponseEntity<>(taskService.getTaskById(projectId, taskId), HttpStatus.OK);
    }  
    
    @PostMapping("/task") 
    public ResponseEntity<?> createTask (@PathVariable("projectId") long projectId) {
        return new ResponseEntity<>(taskService.createTaskForProject(projectId), HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<?> deleteTaskById (@PathVariable("projectId") long projectId, 
        @PathVariable("taskId") long taskId) {
            return new ResponseEntity<>(taskService.deleteTaskById(projectId, taskId), HttpStatus.OK);
        }



}
