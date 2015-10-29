package edu.ksu.swe6633.finalproj.domain.requirement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;

public class UpdateRequirement {
    private final int id;
    private final Optional<String> reqId;
    private final Optional<String> description;
    private final Optional<RequirementType> type;

    public UpdateRequirement(@JsonProperty("id") int id,
                             @JsonProperty("reqId") String reqId,
                             @JsonProperty("description") String description,
                             @JsonProperty("type") RequirementType type) {
        this.id = id;
        this.reqId = Optional.fromNullable(reqId);
        this.description = Optional.fromNullable(description);
        this.type = Optional.fromNullable(type);
    }

    public int getId() {
        return id;
    }

    public Optional<String> getReqId() {
        return reqId;
    }

    public Optional<String> getDescription() {
        return description;
    }

    public Optional<RequirementType> getType() {
        return type;
    }
}
