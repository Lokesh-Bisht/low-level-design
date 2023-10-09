package service.impl;

import enums.VehicleType;
import models.Slot;
import models.Ticket;
import service.SlotService;

import java.util.List;

public class SlotServiceImpl implements SlotService {


    public SlotServiceImpl() {
    }

//    @Override
//    public void initializeParkingSlots() {
//        for (int i = 0; i < TOTAL_PARKING_SLOTS; ++i) {
//            int parkingSlots = 0;
//            while (parkingSlots < BIKE_PARKING_SLOTS) {
//                bikeParkingSlots.add(new Slot(i, true));
//                parkingSlots++;
//            }
//            parkingSlots = 0;
//            while (parkingSlots < CAR_PARKING_SLOTS) {
//                carParkingSlots.add(new Slot(i, true));
//                parkingSlots++;
//            }
//            parkingSlots = 0;
//            while (parkingSlots < BUS_PARKING_SLOTS) {
//                busParkingSlots.add(new Slot(i, true));
//                parkingSlots++;
//            }
//        }
//    }

    @Override
    public Slot reserveParkingSlot(Ticket ticket) {
        if (VehicleType.CAR.equals(ticket.getVehicleType())) {
            v
        }
        return new Slot(ticket.getSlotNumber(), true);
    }

    @Override
    public boolean freeParkingSlot(int parking) {
        return false;
    }
}
