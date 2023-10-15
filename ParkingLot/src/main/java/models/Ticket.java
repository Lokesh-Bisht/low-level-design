package models;

import enums.VehicleType;
import factory.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {

    private final UUID ticketId;

    private VehicleType vehicleType;

    private int slotNumber;

    private String vehicleNumber;

    private String vehicleColor;

    private LocalDateTime date;

    public Ticket(VehicleType vehicleType, int slotNumber, Vehicle vehicle, LocalDateTime date) {
        this.ticketId = UUID.randomUUID();
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicle.getVehicleNumber();
        this.vehicleColor = vehicle.getVehicleColor();
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
}
