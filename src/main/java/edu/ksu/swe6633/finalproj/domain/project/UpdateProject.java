package edu.ksu.swe6633.finalproj.domain.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import edu.ksu.swe6633.finalproj.domain.member.Member;
import edu.ksu.swe6633.finalproj.domain.risk.Risk;

import java.util.List;

public class UpdateProject {

    private final int id;

    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<Member> manager;

    private final Optional<List<Member>> teamMembers;

    private final Optional<List<Risk>> risks;

    public UpdateProject(@JsonProperty("id") int id,
                         @JsonProperty("name") String name,
                         @JsonProperty("description") String description,
                         @JsonProperty("manager") Member manager,
                         @JsonProperty("members") List<Member> teamMembers,
                         @JsonProperty("risks") List<Risk> risks) {
        this.id = id;
        this.name = Optional.fromNullable(name);
        this.description = Optional.fromNullable(description);
        this.manager = Optional.fromNullable(manager);
        this.teamMembers = Optional.fromNullable(teamMembers);
        this.risks = Optional.fromNullable(risks);
    }

    public int getId() {
        return id;
    }

    public Optional<String> getName() {
        return name;
    }

    public Optional<String> getDescription() {
        return description;
    }

    public Optional<Member> getManager() {
        return manager;
    }

    public Optional<List<Member>> getTeamMembers() {
        return teamMembers;
    }

    public Optional<List<Risk>> getRisks() {
        return risks;
    }
}
