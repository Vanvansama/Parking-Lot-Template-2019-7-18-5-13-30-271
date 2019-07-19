package com.thoughtworks.parking_lot.model;

import javax.persistence.*;

@Entity
@Table(name = "parkinglot")
public class ParkingLots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "position")
    private Integer position;

    public ParkingLots(String name, Integer capacity, Integer position) {
        this.name = name;
        this.capacity = capacity;
        this.position = position;
    }

    public ParkingLots() {
    }

    public ParkingLots(Integer id, String name, Integer capacity, Integer position) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.position = position;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
