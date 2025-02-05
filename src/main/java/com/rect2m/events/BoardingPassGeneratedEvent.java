package com.rect2m.events;

public class BoardingPassGeneratedEvent {

    private final String passengerName;
    private final String flightNumber;
    private final String boardingPass;
    private final String email;

    public BoardingPassGeneratedEvent(String passengerName, String flightNumber,
            String boardingPass, String email) {
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.boardingPass = boardingPass;
        this.email = email;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getBoardingPass() {
        return boardingPass;
    }

    public String getPassengerEmail() {
        return email;
    }
}
