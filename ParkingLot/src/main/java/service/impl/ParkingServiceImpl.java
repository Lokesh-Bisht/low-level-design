package service.impl;

import exceptions.InvalidVehicleException;
import exceptions.ParkingFullException;
import factory.Vehicle;
import models.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ParkingService;
import service.PricingService;
import service.SlotService;

import java.time.LocalDateTime;

public class ParkingServiceImpl implements ParkingService {

    private static ParkingService parkingService;

    private final SlotService slotService;

    private final PricingService pricingService;

    private static final Logger logger = LoggerFactory.getLogger(ParkingServiceImpl.class);

    private ParkingServiceImpl() {
        slotService = SlotServiceImpl.getInstance();
        pricingService = PricingServiceImpl.getInstance();
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
            if (slotService.hasParkingSlots(vehicle.getVehicleType())) {
                int slotNumber = slotService.reserveParkingSlot(vehicle.getVehicleType());
                Ticket ticket =  new Ticket(vehicle.getVehicleType(), slotNumber, vehicle, LocalDateTime.now());
                logger.info("Ticket: {}", ticket.toString());
            }
            throw new ParkingFullException("Sorry, no space available. PARKING FULL!");
        } catch (InvalidVehicleException | ParkingFullException ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    public void unPark(Ticket ticket) {
        int price = pricingService.generatePrice(ticket.getVehicleType(), LocalDateTime.now(), ticket.getDate());
        logger.info("Parking fee is: {}", price);
        slotService.freeParkingSlot(ticket);
        logger.info("Have a good day :)");
    }
}
