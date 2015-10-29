package edu.ksu.swe6633.finalproj.project;

import edu.ksu.swe6633.finalproj.domain.project.CreateProject;
import edu.ksu.swe6633.finalproj.domain.project.Project;
import edu.ksu.swe6633.finalproj.domain.risk.Risk;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;

@Path("project")
public class ProjectWeb {

    @POST
    public Project createProject(CreateProject createProject) {
        int id = 1;
        return new Project(id, createProject.getName(), createProject.getDescription(), createProject.getManager(), createProject.getTeamMembers(), new ArrayList<Risk>());
    }
}
