package edu.ksu.swe6633.finalproj.domain.risk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRisk {
    private final int id;
    private final RiskStatus status;

    public UpdateRisk(@JsonProperty("id") int id,
                      @JsonProperty("status") RiskStatus status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public RiskStatus getStatus() {
        return status;
    }
}
