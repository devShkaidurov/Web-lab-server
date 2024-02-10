package com.study.first_lab.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.study.first_lab.other.Project;
import com.study.first_lab.other.ProjectPojo;
import com.study.first_lab.service.MainService;

@RestController
@RequestMapping("/projects")
public class MainComponent {
    @Autowired
    private MainService service;

    @PostMapping
    public ProjectPojo creationProject(@RequestBody ProjectPojo project) {
        if (service.createProject(project))
            return project;
        else 
            return null;
    }

    @PutMapping("/{projectName}")
    public int modifyProject(@PathVariable("projectName") String name, @RequestBody ProjectPojo project) {
        if (service.updateProject(project) == 1) 
            return 200;
        else
            return 404;
    }

    @DeleteMapping("/{projectName}")
    public int deleteProject(@PathVariable("projectName") String name) {
        return service.deleteProjectByName(name);
    }

    @GetMapping("/{projectName}")
    public Project getProject(@PathVariable("projectName") String name) {
        return service.getProjectByName(name);
    }

    @GetMapping
    public List<ProjectPojo> getProjectWithFilter(@RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
        @RequestParam("finish_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finishDateTime) {
        List<ProjectPojo> resultList = service.getProjectsWithFilter(startDateTime, finishDateTime);
        return resultList;
    }

    @GetMapping("/all")
    public List<ProjectPojo> getAllProjects() {
        return service.getAllProjects();
    }
}