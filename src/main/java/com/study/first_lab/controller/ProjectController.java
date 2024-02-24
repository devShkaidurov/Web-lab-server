package com.study.first_lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.first_lab.pojo.ProjectPojo;
import com.study.first_lab.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<?> getProjectByDescFilter (@RequestParam("search") String phrase) {
        return new ResponseEntity<>(projectService.getProjectByDescFilter(phrase), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById (@PathVariable("projectId") long projectId) {
        return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProject (@RequestBody ProjectPojo ProjectPojo) {
        return new ResponseEntity<>(projectService.createProject(ProjectPojo), HttpStatus.OK);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<?> updateProjectById (@PathVariable("projectId") long projectId, @RequestBody ProjectPojo projectPojo) {
        return new ResponseEntity<>(projectService.updateProjectById(projectId, projectPojo), HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}") 
    public ResponseEntity<?> deleteProjectById (@PathVariable("projectId") long projectId) {
        return new ResponseEntity<>(projectService.deleteProjectById(projectId), HttpStatus.OK);
    }

 

}
