package org.example.repositories;

import org.example.exceptions.CarNotFoundException;
import org.example.models.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, Car> parkingSlots;
    private Integer capacity;
    public void createParkingLot(int capacity) {
        this.capacity = capacity;
        parkingSlots = new HashMap<>(capacity);
    }

    public int getAvailableSlot() {
        if(parkingSlots.size()<=capacity){
            for(int i=1;i<=capacity;i++){
                if(!parkingSlots.containsKey(i)){
                    return i;
                }
            }
        }
        return -1; // No available slot found
    }
    public void issueTicket(String registrationNumber, String colour, int availabaleSlot) {
        parkingSlots.put(availabaleSlot, new Car(registrationNumber,colour));
    }

    public void returnTicket(int slotNumber) {
        parkingSlots.remove(slotNumber);
    }
    public Map<Integer, Car> getParkingSlots() {
        return parkingSlots;
    }

    public void showRegistrationNumbersByColour(String targetColor) throws CarNotFoundException {
        List<String> matchinRegistrationNumbers = new ArrayList<>();
        for (Car car:parkingSlots.values()){
            if(car!=null && car.getColour().equalsIgnoreCase(targetColor)){
                matchinRegistrationNumbers.add(car.getRegistrationNumber());
            }
        }
        if(matchinRegistrationNumbers.isEmpty()){
            throw new CarNotFoundException("No cars found with the colour "+targetColor);
        } else {
            String result = String.join(", " , matchinRegistrationNumbers) ;
            System.out.println(result);
        }
    }
}
