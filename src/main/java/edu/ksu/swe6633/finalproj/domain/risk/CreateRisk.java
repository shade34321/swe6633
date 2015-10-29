package edu.ksu.swe6633.finalproj.domain.risk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRisk {
    private final String description;
    private final RiskStatus status;

    public CreateRisk(@JsonProperty("description") String description,
                      @JsonProperty("status") RiskStatus status) {
        this.description = description;
        this.status = status;
    }
}
