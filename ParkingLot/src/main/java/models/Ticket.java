package models;

import enums.VehicleType;

import java.util.Date;
import java.util.UUID;

public class Ticket {

    private final UUID ticketId;

    private VehicleType vehicleType;

    private int slotNumber;

    private String vehicleNumber;

    private Date date;

    public Ticket(VehicleType vehicleType, String vehicleNumber, Date date) {
        this.ticketId = UUID.randomUUID();
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.date = date;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
