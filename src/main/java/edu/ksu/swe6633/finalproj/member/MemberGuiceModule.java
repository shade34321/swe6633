package edu.ksu.swe6633.finalproj.member;

import com.google.inject.AbstractModule;
import com.google.inject.servlet.RequestScoped;

public class MemberGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MemberService.class).to(DefaultMemberService.class);
        bind(MemberDao.class).to(MysqlMemberDao.class);

        //And also sets up our REST endpoints to spawn a new thread for each request.
        bind(MemberWeb.class).in(RequestScoped.class);

    }
}
