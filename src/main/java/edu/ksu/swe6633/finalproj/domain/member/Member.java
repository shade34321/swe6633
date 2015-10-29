package edu.ksu.swe6633.finalproj.domain.member;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Member {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String fullName;
    private final MemberRole memberRole;

    public Member(@JsonProperty("memberRole") MemberRole memberRole,
                  @JsonProperty("id") int id,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName) {
        this.memberRole = memberRole;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public MemberRole getMemberRole() {
        return memberRole;
    }
}
