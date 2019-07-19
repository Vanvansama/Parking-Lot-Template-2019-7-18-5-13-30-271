package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingOrderRepository extends JpaRepository<ParkingOrders, Integer> {
    ParkingOrders findByCarIdAndStatus(String carId, Integer status);
}
