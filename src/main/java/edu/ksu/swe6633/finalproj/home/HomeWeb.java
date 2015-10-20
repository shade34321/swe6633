package edu.ksu.swe6633.finalproj.home;

import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * An example Jersey endpoint. All requests from the browser at the annotated path ("home") will go to this class...
 */
@Path("home")
public class HomeWeb {

    private HelloService helloService;

    @Inject
    public HomeWeb(HelloService helloService) {
        this.helloService = helloService;
    }

    @GET //..and if the request is a GET, it will execute this method. We could also annotate it with Path so it could be at /home/newPath
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return helloService.hello();
    }
}
