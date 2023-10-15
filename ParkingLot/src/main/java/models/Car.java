package models;

import enums.VehicleType;
import factory.Vehicle;

public class Car implements Vehicle {

    private String vehicleNumber;

    private String vehicleColor;

    private VehicleType vehicleType;

    public Car(String vehicleNumber, String vehicleColor) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleColor = vehicleColor;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public String getVehicleColor() {
        return vehicleColor;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    @Override
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
