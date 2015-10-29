package edu.ksu.swe6633.finalproj.domain.requirement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Requirement {
    private final int id;
    private final String reqId;
    private final String description;
    private final RequirementType type;

    public Requirement(@JsonProperty("id") int id,
                       @JsonProperty("reqId") String reqId,
                       @JsonProperty("description") String description,
                       @JsonProperty("type") RequirementType type) {
        this.id = id;
        this.reqId = reqId;
        this.description = description;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getReqId() {
        return reqId;
    }

    public String getDescription() {
        return description;
    }

    public RequirementType getType() {
        return type;
    }
}
