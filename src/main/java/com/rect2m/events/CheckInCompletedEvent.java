package com.rect2m.events;

public class CheckInCompletedEvent {

    private final String passengerName;
    private final String flightNumber;

    public CheckInCompletedEvent(String passengerName, String flightNumber) {
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
}
