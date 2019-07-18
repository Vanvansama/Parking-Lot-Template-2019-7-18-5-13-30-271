package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingLotController {

    @PostMapping("/parking-lot")
    public ParkingLot save(ParkingLot parkingLot){
        return null;
    }
}
