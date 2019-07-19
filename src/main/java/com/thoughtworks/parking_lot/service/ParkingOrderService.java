package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLots;
import com.thoughtworks.parking_lot.model.ParkingOrders;
import com.thoughtworks.parking_lot.repository.ParkingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingOrderService {

    @Autowired
    private ParkingLotService parkingLotService;
    @Autowired
    private ParkingOrderRepository parkingOrderRepository;

    public ParkingOrders parking(String carId) {
        ParkingLots parkingLots = parkingLotService.findById(1);
        ParkingOrders parkingOrders = new ParkingOrders(parkingLots.getName(), carId);
        int position = parkingLots.getPosition();
        if (position > 0) {
            parkingLots.setCapacity(position - 1);
            parkingLotService.update(parkingLots.getId(), parkingLots);
            return parkingOrderRepository.save(parkingOrders);
        }else {
            throw new RuntimeException("停车场已满");
        }
    }

    public ParkingOrders fetch(String carId) {
        ParkingOrders parkingOrders = parkingOrderRepository.findByCarIdAndStatus(carId, 1);
        if (parkingOrders != null){
            parkingOrders.setEndTime(System.currentTimeMillis());
            parkingOrders.setStatus(0);
            parkingOrderRepository.save(parkingOrders);
        }
        return null;
    }
}
