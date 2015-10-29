package edu.ksu.swe6633.finalproj.member;

import javax.inject.Inject;
import edu.ksu.swe6633.finalproj.domain.member.CreateMember;
import edu.ksu.swe6633.finalproj.domain.member.Member;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("member")
public class MemberWeb {

    private final MemberService memberService;

    @Inject
    public MemberWeb(MemberService memberService) {
        this.memberService = memberService;
    }

    @POST
    public Member createMember(CreateMember createMember) {
        return memberService.add(createMember);
    }

    @GET
    public List<Member> getMembers() {
        return memberService.getMembers();
    }
}
