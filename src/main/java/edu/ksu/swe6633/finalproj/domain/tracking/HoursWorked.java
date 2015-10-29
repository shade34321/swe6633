package edu.ksu.swe6633.finalproj.domain.tracking;

public class HoursWorked {

    private final int hours;
    private final Timeframe timeframe;

    public HoursWorked(int hours, Timeframe timeframe) {
        this.hours = hours;
        this.timeframe = timeframe;
    }

    public int getHours() {
        return hours;
    }

    public Timeframe getTimeframe() {
        return timeframe;
    }

    static enum Timeframe {
        DAILY,
        WEEKLY,
    }
}
