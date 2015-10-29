package edu.ksu.swe6633.finalproj.domain.tracking;

public enum RequirementPhase {
    REQUIREMENT_ANALYSIS("Requirement Analysis"),
    DESIGN("Design"),
    CODING("Coding"),
    TESTING("Testing"),
    PROJECT_MANAGEMENT("Project Management");

    private final String phaseName;

    RequirementPhase(String phaseName) {
        this.phaseName = phaseName;
    }

    public String getPhaseName() {
        return phaseName;
    }
}
