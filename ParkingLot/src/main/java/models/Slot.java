package models;

public class Slot {

    private int slotNumber;

    private boolean isAvailable;

    public Slot(int slotNumber, boolean isAvailable) {
        this.slotNumber = slotNumber;
        this.isAvailable = isAvailable;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
