package edu.ksu.swe6633.finalproj.domain.project;

import edu.ksu.swe6633.finalproj.domain.member.Member;
import edu.ksu.swe6633.finalproj.domain.risk.Risk;

import java.util.List;

public class Project {
    private final int id;

    private final String name;

    private final String description;

    private final Member manager;

    private final List<Member> teamMembers;

    private final List<Risk> risks;

    public Project(int id,
                   String name,
                   String description,
                   Member manager,
                   List<Member> teamMembers,
                   List<Risk> risks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manager = manager;
        this.teamMembers = teamMembers;
        this.risks = risks;
    }

    public int getId() {
        return id;
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

    public List<Risk> getRisks() {
        return risks;
    }
}
