package service;

import enums.VehicleType;
import exceptions.InvalidVehicleException;

public interface SlotService {

    boolean hasParkingSlots(VehicleType vehicleType) throws InvalidVehicleException;
    int reserveParkingSlot(VehicleType vehicleType);
}
