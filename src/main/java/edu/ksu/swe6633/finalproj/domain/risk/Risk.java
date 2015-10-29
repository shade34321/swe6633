package edu.ksu.swe6633.finalproj.domain.risk;

public class Risk {
    private final int id;
    private final String description;
    private final RiskStatus status;

    public Risk(int id, String description, RiskStatus status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public RiskStatus getStatus() {
        return status;
    }
}
