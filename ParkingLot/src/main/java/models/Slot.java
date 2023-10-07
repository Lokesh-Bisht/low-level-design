package models;

import factory.Vehicle;

public class Slot {

    private int slotNumber;

    private boolean isEmpty;

    private Vehicle vehicle;

    public Slot(int slotNumber, boolean isEmpty) {
        this.slotNumber = slotNumber;
        this.isEmpty = isEmpty;
    }
}
