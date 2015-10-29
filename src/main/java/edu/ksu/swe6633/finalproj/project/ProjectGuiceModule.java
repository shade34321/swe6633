package edu.ksu.swe6633.finalproj.project;

import com.google.inject.AbstractModule;
import com.google.inject.servlet.RequestScoped;
import edu.ksu.swe6633.finalproj.home.HomeWeb;

public class ProjectGuiceModule extends AbstractModule {
    @Override
    protected void configure() {

        //And also sets up our REST endpoints to spawn a new thread for each request.
        bind(HomeWeb.class).in(RequestScoped.class);

    }
}
