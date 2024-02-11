package com.study.first_lab.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.study.first_lab.other.ProjectPojo;
import com.study.first_lab.service.MainService;

@RestController
@RequestMapping("/projects")
public class MainComponent {
    @Autowired
    private MainService service;

    @PostMapping
    public ResponseEntity<?> creationProject(@RequestBody ProjectPojo project) {
        if (service.createProject(project))
            return new ResponseEntity<>(project, HttpStatus.CREATED);
        else 
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{projectName}")
    public ResponseEntity<?> modifyProject(@PathVariable("projectName") String name, @RequestBody ProjectPojo project) {
        if (service.updateProject(name, project) == 1) 
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{projectName}")
    public ResponseEntity<?> deleteProject(@PathVariable("projectName") String name) {
        service.deleteProjectByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{projectName}")
    public ResponseEntity<?> getProject(@PathVariable("projectName") String name) {
        ProjectPojo project = service.getProjectByName(name);
        if (project == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else 
            return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getProjectWithFilter(@RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
        @RequestParam("finish_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finishDateTime) {
        return new ResponseEntity<>(service.getProjectsWithFilter(startDateTime, finishDateTime), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProjects() {
        return new ResponseEntity<>(service.getAllProjects(), HttpStatus.OK);
    }
}