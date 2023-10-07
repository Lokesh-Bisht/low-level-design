package factory;

import enums.VehicleType;

public interface Vehicle {

    String getVehicleNumber();
    String getVehicleColor();
    VehicleType getVehicleType();
    void setVehicleNumber(String vehicleNumber);
    void setVehicleColor(String vehicleColor);
    void setVehicleType(VehicleType vehicleType);
}
