package com.study.first_lab.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.study.first_lab.other.Project;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProjectDAOImpl implements ProjectDAO {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper<Project> projectMapper = (rs, rowNum) -> {
        Project project = new Project();
        project.setNameProject(rs.getString("nameProject"));
        project.setDescriptionProject(rs.getString("descriptionProject"));
        project.setStartDateTime(rs.getDate("startDateTime"));
        project.setFinishDateTime(rs.getDate("finishDateTime"));
        return project;
    };

    public boolean createProject(Project project) {
        try {
            int result = jdbcTemplate.update("insert into Project (nameProject, descriptionProject, startDateTime, finishDateTime) values (?, ?, ?, ?)", 
                project.getNameProject(), project.getDescriptionProject(), project.getStartDateTime(), project.getFinishDateTime());
            if (result == 1)
                return true;
            else 
                return false;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    public int modifyProject(String name, Project project) {
        return jdbcTemplate.update("update Project SET nameProject = ?, descriptionProject = ?, startDateTime = ?, finishDateTime = ? WHERE nameProject = ?",
            new Object[] { project.getNameProject(), project.getDescriptionProject(), project.getStartDateTime(), project.getFinishDateTime(), name }
        );
    }

    public void deleteProject(String nameProject) {
        Map<String, String> param = Map.of("nameProject", nameProject);
        namedParameterJdbcTemplate.update("DELETE from Project where nameProject = :nameProject", param);
        // result = 1 -> deleted
        // result = 0 -> not found PK
    }

    public Project getProject(String nameProject) {
        List<Project> resultList = jdbcTemplate.query("select * from project where nameproject = ?", 
            projectMapper,
            new Object[] { nameProject }
        );
        if (resultList.size() == 0)
            return null;
        else
            return resultList.get(0);
    }

    public List<Project> getProjectsWithFilter(LocalDateTime startTime, LocalDateTime finishTime) {
        return jdbcTemplate.query("select * from project where startdatetime > ? and finishdatetime < ?", 
            projectMapper,
            new Object[] { startTime, finishTime }
        );
    }

    public List<Project> getAllProjects() {
        return jdbcTemplate.query("select * from project", projectMapper);
    }
}
