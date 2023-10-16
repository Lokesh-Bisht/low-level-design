package service;

import enums.VehicleType;
import models.Ticket;

import java.time.LocalDateTime;

public interface PricingService {

    int generatePrice(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime);
}
