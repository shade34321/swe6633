package edu.ksu.swe6633.finalproj.domain.requirement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRequirement {
    private final String reqId;
    private final String description;
    private final RequirementType type;

    public CreateRequirement(@JsonProperty("reqId") String reqId,
                             @JsonProperty("description") String description,
                             @JsonProperty("type") RequirementType type) {
        this.reqId = reqId;
        this.description = description;
        this.type = type;
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
