package edu.ksu.swe6633.finalproj.member;

import javax.inject.Inject;
import edu.ksu.swe6633.finalproj.domain.member.CreateMember;
import edu.ksu.swe6633.finalproj.domain.member.Member;

import java.util.List;

public class DefaultMemberService implements MemberService {

    private final MemberDao memberDao;

    @Inject
    public DefaultMemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Member add(CreateMember create) {
        Member member = memberDao.addMember(create);
        return member;
    }

    @Override
    public List<Member> getMembers() {
        return memberDao.getMembers();
    }
}
