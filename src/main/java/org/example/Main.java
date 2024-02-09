package org.example;


import org.example.controllers.ParkingLotController;
import org.example.exceptions.CarNotFoundException;
import org.example.exceptions.ParkingFullException;
import org.example.repositories.ParkingLotRepository;
import org.example.services.ParkingLotService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        ParkingLotController parkingLotController = new ParkingLotController(parkingLotService);

        while (true){
            System.out.print("$ ");
            String command = scan.nextLine() ;
            String[] input = command.split(" ");

            switch (input[0].toLowerCase()){
                case "create_parking_lot":
                    int capacity = Integer.parseInt(input[1]);
                    parkingLotController.createParkingLot(capacity);
                    break;
                case "park":
                    String registrationNumber = input[1];
                    String colour = input[2] ;
                    try {
                        parkingLotController.issueTicket(registrationNumber,colour);
                    } catch (ParkingFullException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "leave" :
                    int slotNumber = Integer.parseInt(input[1]);
                    parkingLotController.returnTicket(slotNumber);
                    break ;
                case "status" :
                    parkingLotController.showStatus();
                    break ;
                case "registration_numbers_for_cars_with_colour":
                    String targetColor = input[1];
                    try {
                        parkingLotController.showRegistrationNumbersByColor(targetColor);
                    } catch (CarNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit" :
                    System.out.println("Exiting the parking system.");
                    System.exit(0);
                    break;
                default :
                    System.out.println("Invalid command. Please Enter again.");
            }
        }
    }
}