package edu.ksu.swe6633.finalproj.domain.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.ksu.swe6633.finalproj.domain.member.Member;
import edu.ksu.swe6633.finalproj.domain.risk.CreateRisk;
import edu.ksu.swe6633.finalproj.domain.risk.Risk;

import java.util.List;

public class CreateProject {
    private final String name;

    private final String description;

    private final Member manager;

    private final List<Member> teamMembers;

    private final List<CreateRisk> risks;

    public CreateProject(@JsonProperty("name") String name,
                         @JsonProperty("description") String description,
                         @JsonProperty("manager") Member manager,
                         @JsonProperty("members") List<Member> teamMembers,
                         @JsonProperty("risks") List<CreateRisk> risks) {
        this.name = name;
        this.description = description;
        this.manager = manager;
        this.teamMembers = teamMembers;
        this.risks = risks;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Member getManager() {
        return manager;
    }

    public List<Member> getTeamMembers() {
        return teamMembers;
    }

    public List<CreateRisk> getRisks() {
        return risks;
    }
}
