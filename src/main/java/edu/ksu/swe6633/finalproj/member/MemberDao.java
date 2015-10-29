package edu.ksu.swe6633.finalproj.member;

import edu.ksu.swe6633.finalproj.domain.member.CreateMember;
import edu.ksu.swe6633.finalproj.domain.member.Member;

import java.util.List;

public interface MemberDao {

    Member addMember(CreateMember create);

    List<Member> getMembers();
}
