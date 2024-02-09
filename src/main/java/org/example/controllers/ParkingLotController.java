package org.example.controllers;

import org.example.models.Car;
import org.example.models.ParkingLot;
import org.example.services.ParkingLotService;

import java.util.Map;
import java.util.PriorityQueue;

public class ParkingLotController {
    private ParkingLotService parkingLotService ;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }
    public void createParkingLot(int capacity){
        parkingLotService.createParkingLot(capacity);
        System.out.println("Created Parking Lot with " + capacity + " slots");
    }

    public void showStatus(){
        Map<Integer , Car> parkingSlots = parkingLotService.getParkingSlots() ;
        if(parkingSlots.isEmpty()){
            System.out.println("Parking Lot is Empty... ");
        } else {
            System.out.println("Slot Number     Registration Number    Colour");
            for (Map.Entry<Integer,Car> entry : parkingSlots.entrySet()){
                int slotNumber = entry.getKey() ;
                Car car = entry.getValue();
                System.out.println(slotNumber+"   "+car.getRegistrationNumber() +"  "+car.getColour());
            }
        }
    }
    public void issueTicket(String registrationNumber , String colour) {
        int allocatedSlot = parkingLotService.issueTicket(registrationNumber,colour);
        if(allocatedSlot!=-1){
            System.out.println("Allocated slot number : " + allocatedSlot );
        } else {
            System.out.println("Sorry..!! Parking Lot is full");
        }
    }
    public void returnTicket(int slotNumber){
        parkingLotService.returnTicket(slotNumber) ;
        System.out.println("Slot Number "+ slotNumber +" is Free!!") ;
    }
    public void showRegistrationNumbersByColor(String targetColor) {
       parkingLotService.showRegistrationNumbersByColour(targetColor);
    }
}
