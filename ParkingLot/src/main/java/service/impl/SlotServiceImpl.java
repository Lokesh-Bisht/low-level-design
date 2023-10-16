package service.impl;

import enums.VehicleType;
import exceptions.InvalidVehicleException;
import models.Slot;
import models.Ticket;
import service.SlotService;

import java.util.ArrayList;
import java.util.List;

public class SlotServiceImpl implements SlotService {

    private static SlotService slotService;

    private static final List<Slot> carParkingSlots;

    private static final List<Slot> busParkingSlots;

    private static final List<Slot> bikeParkingSlots;

    public static final int CAR_PARKING_SLOTS = 200;

    public static final int BUS_PARKING_SLOTS = 50;

    public static final int BIKE_PARKING_SLOTS = 100;

    public static final int TOTAL_PARKING_SLOTS = 350;

    static {
        carParkingSlots = new ArrayList<>();
        busParkingSlots = new ArrayList<>();
        bikeParkingSlots = new ArrayList<>();
        initializeParkingSlots();
    }

    private SlotServiceImpl() {}

    public static SlotService getInstance() {
        if (slotService == null) {
            return new SlotServiceImpl();
        }
        return slotService;
    }

    private static void initializeParkingSlots() {
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
    public boolean hasParkingSlots(VehicleType vehicleType) throws InvalidVehicleException {
        if (VehicleType.CAR.equals(vehicleType)) {
            return carParkingSlots.size() != CAR_PARKING_SLOTS;
        } else if (VehicleType.BUS.equals(vehicleType)) {
            return busParkingSlots.size() != BUS_PARKING_SLOTS;
        } else if (VehicleType.BIKE.equals(vehicleType)) {
            return bikeParkingSlots.size() != BIKE_PARKING_SLOTS;
        }
        throw new InvalidVehicleException("Invalid vehicle! Parking is available only for car, bus, and bike.");
    }

    @Override
    public int reserveParkingSlot(VehicleType vehicleType) {
        int slotNumber = -1;
        if (VehicleType.BIKE.equals(vehicleType)) {
            slotNumber = bikeParkingSlots.size() + 1;
            bikeParkingSlots.get(slotNumber).setAvailable(false);
        } else if (VehicleType.CAR.equals(vehicleType)) {
            slotNumber = BIKE_PARKING_SLOTS + carParkingSlots.size() + 1;
            carParkingSlots.get(slotNumber).setAvailable(false);
        } else if (VehicleType.BUS.equals(vehicleType)) {
            slotNumber = BIKE_PARKING_SLOTS + CAR_PARKING_SLOTS + busParkingSlots.size() + 1;
            busParkingSlots.get(slotNumber).setAvailable(false);
        }
        return slotNumber;
    }

    @Override
    public void freeParkingSlot(Ticket ticket) {
        VehicleType vehicleType = ticket.getVehicleType();
        int slotNumber = ticket.getSlotNumber();
        if (VehicleType.BIKE.equals(vehicleType)) {
            bikeParkingSlots.get(slotNumber).setAvailable(true);
        } else if (VehicleType.CAR.equals(vehicleType)) {
            carParkingSlots.get(slotNumber).setAvailable(true);
        } else if (VehicleType.BUS.equals(vehicleType)) {
            busParkingSlots.get(slotNumber).setAvailable(true);
        }
    }
}
