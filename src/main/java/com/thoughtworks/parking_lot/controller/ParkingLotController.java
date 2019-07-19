package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLots;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping("/parking-lot")
    public ParkingLots save(ParkingLots parkingLots){
        return parkingLotService.save(parkingLots);
    }

    @PostMapping("/parking-lot/{id}")
    public ParkingLots update(@PathVariable Integer id, ParkingLots parkingLots){
        return parkingLotService.update(id, parkingLots);
    }

    @DeleteMapping("/parking-lot/{parkingLotId}")
    public ParkingLots delete(@PathVariable Integer parkingLotId){
        return parkingLotService.delete(parkingLotId);
    }

    @GetMapping(value = "/parking-lot",params = {"page","pageSize"})
    public Page<ParkingLots> getByPage(@RequestParam Integer page, @RequestParam Integer pageSize){
        return parkingLotService.findByPage(page, pageSize);

    }

    @GetMapping("/parking-lot/{parkingLotId}")
    public ParkingLots get (@PathVariable Integer parkingLotId){
        return parkingLotService.findById(parkingLotId);
    }


}
