package com.rect2m.handlers;


import com.rect2m.events.CheckInCompletedEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckInLogger implements EventHandler<CheckInCompletedEvent> {

    private static final Logger logger = Logger.getLogger(CheckInLogger.class.getName());

    @Override
    public void handle(CheckInCompletedEvent event) {
        logger.log(Level.INFO, "Пасажир {0} зареєструвався на рейс {1}",
                new Object[]{event.getPassengerName(), event.getFlightNumber()});
    }
}
