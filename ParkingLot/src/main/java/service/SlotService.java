package service;

import enums.VehicleType;
import exceptions.InvalidVehicleException;
import models.Ticket;

public interface SlotService {

    boolean hasParkingSlots(VehicleType vehicleType) throws InvalidVehicleException;
    int reserveParkingSlot(VehicleType vehicleType);
    void freeParkingSlot(Ticket ticket);
}
