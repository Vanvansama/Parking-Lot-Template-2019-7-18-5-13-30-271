package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingOrders;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import com.thoughtworks.parking_lot.service.ParkingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingOrderController {
    @Autowired
    private ParkingOrderService parkingOrderService;

    @PostMapping("/parking/{carId}")
    public ParkingOrders parking(@PathVariable String carId){
        return parkingOrderService.parking(carId);
    }

    @GetMapping("/fetch/{carId}")
    public ParkingOrders fetch(@PathVariable String carId){
        return parkingOrderService.fetch(carId);
    }

}
