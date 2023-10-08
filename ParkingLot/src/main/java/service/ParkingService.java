package service;

import factory.Vehicle;
import models.Ticket;

public interface ParkingService {

    void initializeParkingSlots();
    Ticket park(Vehicle vehicle);
}
