package edu.ksu.swe6633.finalproj.config;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import edu.ksu.swe6633.finalproj.config.database.DataSourceModule;
import edu.ksu.swe6633.finalproj.config.shutdown.*;
import edu.ksu.swe6633.finalproj.home.HomeGuiceModule;
import edu.ksu.swe6633.finalproj.member.MemberGuiceModule;

import javax.inject.Singleton;

public class DefaultGuiceServletConfig extends GuiceServletContextListener {
    public static Injector injector;

    @Override
    protected Injector getInjector() {
        injector = Guice.createInjector(Stage.DEVELOPMENT,
                //Add modules here
                new DataSourceModule(),
                new HomeGuiceModule(),
                new MemberGuiceModule(),
                new ServletModule()
        );
        return injector;
    }

    static class ShutdownModule extends AbstractModule {


        @Override
        protected void configure() {
            bind(Shutdown.class).in(Singleton.class);
        }
    }
}
