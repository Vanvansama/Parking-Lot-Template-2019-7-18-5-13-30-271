package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLots;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public ParkingLots save(ParkingLots parkingLots) {
        return parkingLotRepository.save(parkingLots);
    }

    public ParkingLots findById(Integer parkingLotId) {
        return parkingLotRepository.findById(parkingLotId).orElse(null);
    }

    public ParkingLots delete(Integer parkingLotId) {
        ParkingLots parkingLots = parkingLotRepository.findById(parkingLotId).orElse(null);
        if (parkingLots != null){
            parkingLotRepository.deleteById(parkingLotId);
            return parkingLots;
        }
        return null;
    }

    public Page<ParkingLots> findByPage(Integer page, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return parkingLotRepository.findAll(pageable);
    }

    public ParkingLots update(Integer id, ParkingLots parkingLots) {
        if (parkingLotRepository.existsById(id)){
            return parkingLotRepository.save(parkingLots);
        }
        return null;
    }
}
