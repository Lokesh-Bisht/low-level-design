package service.impl;

import factory.Vehicle;
import models.Slot;
import models.Ticket;
import service.ParkingService;

import java.util.ArrayList;
import java.util.List;

public class ParkingServiceImpl implements ParkingService {

    private static ParkingService parkingService;

    private final List<Slot> carParkingSlots;

    private final List<Slot> busParkingSlots;

    private final List<Slot> bikeParkingSlots;

    public static final int CAR_PARKING_SLOTS = 200;

    public static final int BUS_PARKING_SLOTS = 50;

    public static final int BIKE_PARKING_SLOTS = 100;

    public static final int TOTAL_PARKING_SLOTS = 350;

    private ParkingServiceImpl() {
        this.carParkingSlots = new ArrayList<>();
        this.busParkingSlots = new ArrayList<>();
        this.bikeParkingSlots = new ArrayList<>();
    }

    public static ParkingService getParkingLot() {
        if (parkingService == null) {
            return new ParkingServiceImpl();
        }
        return parkingService;
    }

    @Override
    public void initializeParkingSlots() {
        for (int i = 0; i < TOTAL_PARKING_SLOTS; ++i) {
            int parkingSlots = 0;
            while (parkingSlots < BIKE_PARKING_SLOTS) {
                bikeParkingSlots.add(new Slot(i, true));
                parkingSlots++;
            }
            parkingSlots = 0;
            while (parkingSlots < CAR_PARKING_SLOTS) {
                carParkingSlots.add(new Slot(i, true));
                parkingSlots++;
            }
            parkingSlots = 0;
            while (parkingSlots < BUS_PARKING_SLOTS) {
                busParkingSlots.add(new Slot(i, true));
                parkingSlots++;
            }
        }
    }

    @Override
    public Ticket park(Vehicle vehicle) {
        return null;
    }
}
