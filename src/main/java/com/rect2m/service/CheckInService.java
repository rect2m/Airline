package com.rect2m.service;

import com.rect2m.events.BoardingPassGeneratedEvent;
import com.rect2m.events.CheckInCompletedEvent;
import com.rect2m.handlers.EventHandler;
import java.util.ArrayList;
import java.util.List;

public class CheckInService {

    private final List<EventHandler<CheckInCompletedEvent>> checkInHandlers = new ArrayList<>();
    private final List<EventHandler<BoardingPassGeneratedEvent>> boardingPassHandlers = new ArrayList<>();

    public void addCheckInHandler(EventHandler<CheckInCompletedEvent> handler) {
        checkInHandlers.add(handler);
    }

    public void addBoardingPassHandler(EventHandler<BoardingPassGeneratedEvent> handler) {
        boardingPassHandlers.add(handler);
    }

    public void checkInPassenger(String passengerName, String flightNumber, String email) {
        CheckInCompletedEvent checkInEvent = new CheckInCompletedEvent(passengerName, flightNumber);
        checkInHandlers.forEach(handler -> handler.handle(checkInEvent));

        String boardingPass = "BP-" + passengerName.hashCode() + "-" + flightNumber;
        BoardingPassGeneratedEvent boardingPassEvent = new BoardingPassGeneratedEvent(passengerName,
                flightNumber, boardingPass, email);
        boardingPassHandlers.forEach(handler -> handler.handle(boardingPassEvent));
    }
}
