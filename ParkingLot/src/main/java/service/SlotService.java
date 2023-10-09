package service;

import models.Slot;
import models.Ticket;

public interface SlotService {

    void initializeParkingSlots();
    Slot reserveParkingSlot(Ticket ticket);
    boolean freeParkingSlot(int parking);
}
