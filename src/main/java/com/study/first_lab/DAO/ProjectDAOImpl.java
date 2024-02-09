package com.study.first_lab.dao;

import java.sql.Date;
import java.util.List;

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

    public int createProject() {
        return 200;
    }

    public int modifyProject(String nameProject) {
        return 200;
    }

    public int deleteProject(String nameProject) {
        return 200;
    }

    public Project getProject(String nameProject) {
        System.out.println("nameProject");
        List<Project> resultList = jdbcTemplate.query("select * from project where nameProject = ?",
                new Object[] { nameProject },
                projectMapper);
        if (resultList.size() == 0)
            return null;
        else
            return resultList.get(0);
    }

    public Project[] getProjectsWithFilter(Date startTime, Date finishTime) {
        Project[] resultList = new Project[10];
        return resultList;
    }
}
