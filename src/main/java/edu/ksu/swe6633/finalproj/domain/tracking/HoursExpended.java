package edu.ksu.swe6633.finalproj.domain.tracking;

import com.fasterxml.jackson.annotation.JsonProperty;

import edu.ksu.swe6633.finalproj.domain.member.Member;
import edu.ksu.swe6633.finalproj.domain.requirement.Requirement;
public class HoursExpended {
    private final Requirement reqWorked;
    private final Member worker;
    private final RequirementPhase phase;

    public HoursExpended(@JsonProperty("phase") RequirementPhase phase,
                         @JsonProperty("worker") Member worker,
                         @JsonProperty("reqWorked") Requirement reqWorked) {
        this.phase = phase;
        this.worker = worker;
        this.reqWorked = reqWorked;
    }

    public Requirement getReqWorked() {
        return reqWorked;
    }

    public Member getWorker() {
        return worker;
    }

    public RequirementPhase getPhase() {
        return phase;
    }
}
