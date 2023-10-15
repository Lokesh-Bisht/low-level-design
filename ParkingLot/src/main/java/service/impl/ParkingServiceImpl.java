package service.impl;

import exceptions.InvalidVehicleException;
import exceptions.ParkingFullException;
import factory.Vehicle;
import models.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.SlotRepository;
import service.ParkingService;

import java.time.LocalDateTime;

public class ParkingServiceImpl implements ParkingService {

    private static ParkingService parkingService;

    private final SlotRepository slotRepository;

    private static final Logger logger = LoggerFactory.getLogger(ParkingServiceImpl.class);

    private ParkingServiceImpl() {
        slotRepository = SlotRepository.getInstance();
    }

    public static ParkingService getInstance() {
        if (parkingService == null) {
            return new ParkingServiceImpl();
        }
        return parkingService;
    }

    @Override
    public void park(Vehicle vehicle) {
        try {
            if (slotRepository.hasParkingSlots(vehicle.getVehicleType())) {
                int slotNumber = slotRepository.reserveParkingSlot(vehicle.getVehicleType());
                Ticket ticket =  new Ticket(vehicle.getVehicleType(), slotNumber, vehicle, LocalDateTime.now());
                logger.info("Ticket: {}", ticket.toString());
            }
            throw new ParkingFullException("Sorry, no space available. PARKING FULL!");
        } catch (InvalidVehicleException | ParkingFullException ex) {
            logger.error(ex.getMessage());
        }
    }
}
