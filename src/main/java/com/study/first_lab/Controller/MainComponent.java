package com.study.first_lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.study.first_lab.other.Project;
import com.study.first_lab.service.MainService;

@RestController
@RequestMapping("/projects")
public class MainComponent {
    @Autowired
    private MainService service;

    @PostMapping
    public int creationProject() {
        return 200;
    }

    @PutMapping("/{projectId}")
    public int modifyProject(@PathVariable("projectId") String name) {
        return 200;
    }

    @DeleteMapping("/{projectId}")
    public int deleteProject(@PathVariable("projectId") String name) {
        return 204;
    }

    @GetMapping("/{projectId}")
    public Project getProject(@PathVariable("projectId") String name) {
        System.out.println("nameProject");
        return service.getProjectByName(name);
    }

    @GetMapping
    public List<Project> getProjectWithFilter(@RequestParam("start_date") String startTime,
            @RequestParam("start_date") String endTime) {
        return null;
    }
}