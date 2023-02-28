package com.finology.car.car;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class Car extends PanacheEntity {

    @NotNull
    @Column(name = "MODEL")
    private String model;

    @NotNull
    @Column(name = "CAR_TYPE")
    private CarType carType;






}
