package com.rect2m;


import com.rect2m.handlers.BoardingPassEmailSender;
import com.rect2m.handlers.CheckInLogger;
import com.rect2m.service.CheckInService;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        CheckInService checkInService = new CheckInService();

        checkInService.addCheckInHandler(new CheckInLogger());
        checkInService.addBoardingPassHandler(new BoardingPassEmailSender());

        Scanner scanner = new Scanner(System.in);
        String passengerName;
        String flightNumber;
        String email;

        do {
            System.out.print("Введіть ім'я пасажира (не може бути порожнім): ");
            passengerName = scanner.nextLine().trim();
        } while (passengerName.isEmpty());

        do {
            System.out.print("Введіть номер рейсу (формат PS123): ");
            flightNumber = scanner.nextLine().trim().toUpperCase();
        } while (!flightNumber.matches("[A-Z]{2}\\d{3,4}"));

        do {
            System.out.print("Введіть електронну пошту: ");
            email = scanner.nextLine().trim();
        } while (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email));

        checkInService.checkInPassenger(passengerName, flightNumber, email);

        scanner.close();
    }
}