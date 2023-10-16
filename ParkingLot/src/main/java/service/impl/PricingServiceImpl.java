package service.impl;

import enums.VehicleType;
import service.PricingService;

import java.time.LocalDateTime;
import java.util.List;

public class PricingServiceImpl implements PricingService {

    private static PricingService pricingService;

    private static final List<Integer> bikeParkingPriceList = List.of(20, 40, 60);

    private static final List<Integer> carParkingPriceList = List.of(30, 50, 70);

    private static final List<Integer> busParkingPriceList = List.of(50, 80, 120);

    private PricingServiceImpl() {}

    public static PricingService getInstance() {
        if (pricingService == null) {
            return new PricingServiceImpl();
        }
        return pricingService;
    }

    @Override
    public int generatePrice(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime) {
        int price = 0;
        int hour =  exitTime.getHour() - entryTime.getHour();
        int minute = exitTime.getMinute() - entryTime.getMinute();
        int time = hour * 60 + minute;
        price = switch (vehicleType) {
            case BIKE -> time <= 60 ? bikeParkingPriceList.get(0) : time <= 150 ? bikeParkingPriceList.get(1) : bikeParkingPriceList.get(2);
            case CAR -> time <= 60 ? carParkingPriceList.get(0) : time <= 150 ? carParkingPriceList.get(1) : carParkingPriceList.get(2);
            case BUS -> time <= 60 ? busParkingPriceList.get(0) : time <= 150 ? busParkingPriceList.get(1) : busParkingPriceList.get(2);
        };
        return price;
    }
}
