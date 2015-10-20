package edu.ksu.swe6633.finalproj.home;

import com.google.inject.AbstractModule;
import com.google.inject.servlet.RequestScoped;

public class HomeGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        //This is where we bind our interfaces to our implementations, this lets everything know which *Service and *Dao to use
        bind(HelloService.class).to(DefaultHelloService.class);
        bind(HelloDao.class).to(MySqlHelloDao.class);

        //And also sets up our REST endpoints to spawn a new thread for each request.
        bind(HomeWeb.class).in(RequestScoped.class);
    }
}
