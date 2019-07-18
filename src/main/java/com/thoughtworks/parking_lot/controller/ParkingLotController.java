package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingLotController {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @PostMapping("/parking-lot")
    public ParkingLot save(ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
    }

    @DeleteMapping("/parking-lot/{parkingId}")
    public void delete(@PathVariable Integer parkingId){
        parkingLotRepository.deleteById(parkingId);
    }
}
