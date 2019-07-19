package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLots;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Create with IDEA
 *
 * @Author: gitee.com/KamisamaXX
 * @Date: Create in 20:53 2019/7/18
 * @Description:
 */
@DataJpaTest
@ExtendWith(SpringExtension.class)
class ParkingLotsRepositoryTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    void should_return_parking_lot_when_save_given_parking_lot(){
        ParkingLots parkingLots = new ParkingLots("stefan",50,20);
        ParkingLots parkingLotsSave = parkingLotRepository.save(parkingLots);

        ParkingLots parkingLotsGet = parkingLotRepository.findById(parkingLotsSave.getId()).orElse(null);

        Assertions.assertEquals(parkingLotsSave, parkingLotsGet);
    }

    @Test
    void should_return_void_when_delete_given_parking_lot(){
        ParkingLots parkingLots = new ParkingLots("stefan",50,20);
        ParkingLots parkingLotsSave = parkingLotRepository.save(parkingLots);
        parkingLotRepository.deleteById(parkingLotsSave.getId());

        Assertions.assertEquals(0,parkingLotRepository.findAll().size());
    }

    @Test
    void should_return_parking_lot_when_findByPage_given_parkingId(){
        ParkingLots parkingLots = new ParkingLots("stefan",50,20);
        ParkingLots parkingLotsSave = parkingLotRepository.save(parkingLots);
        ParkingLots parkingLotsGet = parkingLotRepository.findById(parkingLotsSave.getId()).orElse(null);

        Assertions.assertEquals(parkingLotsGet,parkingLotsSave);
    }

}