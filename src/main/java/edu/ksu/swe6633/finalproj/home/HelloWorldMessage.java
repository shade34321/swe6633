package edu.ksu.swe6633.finalproj.home;

public class HelloWorldMessage {
    private final int id;
    private final String message;

    public HelloWorldMessage(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
