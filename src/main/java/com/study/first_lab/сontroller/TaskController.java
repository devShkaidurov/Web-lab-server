package com.study.first_lab.сontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.first_lab.pojo.TaskPojo;
import com.study.first_lab.service.TaskService;

@RestController
@RequestMapping("/projects/{projectId}/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getAllTasks (@PathVariable("projectId") long projectId) {
        return new ResponseEntity<>(taskService.getAllTasks(projectId), HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTaskById (@PathVariable("projectId") long projectId, 
        @PathVariable("taskId") long taskId) {
            TaskPojo taskPojo = taskService.getTaskById(projectId, taskId);
            return new ResponseEntity<>(taskPojo, taskPojo == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }  
    
    @PostMapping
    public ResponseEntity<?> createTask (@PathVariable("projectId") long projectId,
        @RequestBody TaskPojo taskPojo) {
        return new ResponseEntity<>(taskService.createTaskForProject(projectId, taskPojo), HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTaskById (@PathVariable("projectId") long projectId, 
        @PathVariable("taskId") long taskId) {
            return new ResponseEntity<>(taskService.deleteTaskById(projectId, taskId), HttpStatus.OK);
        }
    
    @DeleteMapping("/clean")
    public ResponseEntity<?> deleteCompletedTask (@PathVariable("projectId") long projectId) {
        return new ResponseEntity<>(taskService.deleteCompletedTaskByProjectId(projectId), HttpStatus.OK);
    }


}
