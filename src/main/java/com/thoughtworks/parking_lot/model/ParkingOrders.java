package com.thoughtworks.parking_lot.model;

import javax.persistence.*;

@Entity
@Table(name = "parking-lot")
public class ParkingOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "car_id")
    private String carId;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "end_time")
    private Long endTime;

    @Column(name = "status")
    private int status;

    public ParkingOrders(String name, String carId) {
        this.name = name;
        this.carId = carId;
        this.createTime = System.currentTimeMillis();
        this.status = 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
