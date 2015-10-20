package edu.ksu.swe6633.finalproj.config;

import javax.inject.Inject;

import edu.ksu.swe6633.finalproj.config.jackson.Jackson2Feature;
import edu.ksu.swe6633.finalproj.home.HomeWeb;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

public class DefaultApplication extends ResourceConfig {

    @Inject
    public DefaultApplication(ServiceLocator serviceLocator) {
        super(Jackson2Feature.class, MultiPartFeature.class);

        //Register object mapper resolver

        property(JspMvcFeature.TEMPLATES_BASE_PATH, "/");
        register(JspMvcFeature.class);

        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(DefaultGuiceServletConfig.injector);

        //Register Jersey modules
        register(HomeWeb.class);
        //Register Exception Mappers


    }
}
