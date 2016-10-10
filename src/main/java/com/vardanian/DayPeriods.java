package com.vardanian;

public enum DayPeriods {

    MORNING("06:00:00"), DAY("09:00:00"), EVENING("19:00:00"), NIGHT("23:00:00");

    private String time;

    DayPeriods(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return time;
    }
}
