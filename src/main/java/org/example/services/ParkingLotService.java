package org.example.services;

import org.example.exceptions.CarNotFoundException;
import org.example.models.Car;
import org.example.repositories.ParkingLotRepository;

import java.util.Map;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository ;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public void createParkingLot(int capacity) {
        parkingLotRepository.createParkingLot(capacity);
    }

    public Map<Integer, Car> getParkingSlots() {
        return parkingLotRepository.getParkingSlots();
    }
    public int issueTicket(String registrationNumber, String colour) {
        int availableSlot = parkingLotRepository.getAvailableSlot() ;
        if (availableSlot!=-1){
            parkingLotRepository.issueTicket(registrationNumber,colour,availableSlot);
        }
        return availableSlot;
    }

    public void returnTicket(int slotNumber) {
        parkingLotRepository.returnTicket(slotNumber);
    }

    public void showRegistrationNumbersByColour(String targetColor) throws CarNotFoundException {
        parkingLotRepository.showRegistrationNumbersByColour(targetColor);
    }

}
