package com.study.first_lab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.first_lab.dto.ProjectPojo;
import com.study.first_lab.service.ProjectService;

@CrossOrigin
@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<?> getProjectByDescFilter (@RequestParam("search") Optional<String> phrase) {
        List<ProjectPojo> listPojos = projectService.getProjectByDescFilter(phrase);
        return new ResponseEntity<>(listPojos,
                listPojos == null || listPojos.size() == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable("projectId") long projectId) {
        ProjectPojo project = projectService.getProjectById(projectId);
        return new ResponseEntity<>(project, project == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProject(@RequestBody ProjectPojo ProjectPojo) {
        return new ResponseEntity<>(projectService.createProject(ProjectPojo), HttpStatus.OK);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<?> updateProjectById(@PathVariable("projectId") long projectId,
            @RequestBody ProjectPojo projectPojo) {
        ProjectPojo updatedProject = projectService.updateProjectById(projectId, projectPojo);
        return new ResponseEntity<>(updatedProject, updatedProject == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectById(@PathVariable("projectId") long projectId) {
        projectService.deleteProjectById(projectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/open")
    public ResponseEntity<?> getOpenedTasks() {
        return new ResponseEntity<>(projectService.getOpenedTask(), HttpStatus.OK);
    }
}
