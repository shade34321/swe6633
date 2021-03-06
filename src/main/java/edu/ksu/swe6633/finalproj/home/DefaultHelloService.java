package edu.ksu.swe6633.finalproj.home;

import com.google.inject.Inject;

import java.util.List;

public class DefaultHelloService implements HelloService {

    private HelloDao dao;

    @Inject
    public DefaultHelloService(HelloDao dao) {
        this.dao = dao;
    }

    public String hello() {
        HelloWorldMessage message = dao.test();
        return message.getMessage();
    }
}
