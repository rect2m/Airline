package com.rect2m.handlers;


import com.rect2m.events.BoardingPassGeneratedEvent;
import com.rect2m.service.EmailService;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoardingPassEmailSender implements EventHandler<BoardingPassGeneratedEvent> {

    private static final Logger logger = Logger.getLogger(BoardingPassEmailSender.class.getName());

    @Override
    public void handle(BoardingPassGeneratedEvent event) {
        logger.log(Level.INFO, "Відправлено посадковий талон пасажиру {0} для рейсу {1}",
                new Object[]{event.getPassengerName(), event.getFlightNumber()});

        String emailContent = "Шановний " + event.getPassengerName() + ",\n\n"
                + "Ваш посадковий талон для рейсу " + event.getFlightNumber() + " сформовано.\n"
                + "Ваш код: " + event.getBoardingPass() + "\n\n"
                + "Гарного польоту!";

        EmailService.sendEmail(event.getPassengerEmail(), "Ваш посадковий талон", emailContent);
    }
}
