package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 20:53 2019/7/18
 * @Description:
 */
@DataJpaTest
@ExtendWith(SpringExtension.class)
class ParkingLotRepositoryTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    void should_return_parking_lot_when_save_given_parking_lot(){
        ParkingLot parkingLot = new ParkingLot("stefan",50,20);
        ParkingLot parkingLotSave = parkingLotRepository.save(parkingLot);

        ParkingLot parkingLotGet = parkingLotRepository.findById(parkingLotSave.getId()).orElse(null);

        Assertions.assertEquals(parkingLotSave, parkingLotGet);
    }
}