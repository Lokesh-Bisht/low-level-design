package factory;

import enums.VehicleType;
import models.Bike;
import models.Bus;
import models.Car;

public class VehicleFactory {

    public static Vehicle setVehicleFactory(String type, String vehicleNumber, String vehicleColor) {
        if (VehicleType.CAR.name().equalsIgnoreCase(type)) {
            return new Car(vehicleNumber, vehicleColor);
        } else if (VehicleType.BUS.name().equalsIgnoreCase(type)) {
            return new Bus(vehicleNumber, vehicleColor);
        } else if (VehicleType.BIKE.name().equalsIgnoreCase(type)) {
            return new Bike(vehicleNumber, vehicleColor);
        }
        return null;
    }
}
