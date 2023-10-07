package models;

import factory.Vehicle;

public class Bus implements Vehicle {

    private String vehicleNumber;

    private String vehicleColor;

    public Bus(String vehicleNumber, String vehicleColor) {
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
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
}
