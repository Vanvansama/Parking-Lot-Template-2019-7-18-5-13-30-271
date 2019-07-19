package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLots,Integer> {
}
