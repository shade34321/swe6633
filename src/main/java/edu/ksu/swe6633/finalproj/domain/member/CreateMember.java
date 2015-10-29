package edu.ksu.swe6633.finalproj.domain.member;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateMember {
    private final String firstName;
    private final String lastName;
    private final MemberRole memberRole;

    public CreateMember(@JsonProperty("role") String memberRole,
                        @JsonProperty("firstName") String firstName,
                        @JsonProperty("lastName") String lastName) {
        this.memberRole = MemberRole.valueOf(memberRole);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public MemberRole getMemberRole() {
        return memberRole;
    }
}
