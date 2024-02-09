package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity ;
    private Map<Integer,Car> parkingSlots ;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSlots = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<Integer, Car> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(Map<Integer, Car> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
