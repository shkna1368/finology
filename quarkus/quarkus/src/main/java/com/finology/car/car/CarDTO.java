package com.finology.car.car;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class CarDTO {


    private Long id;

    @NotNull
    @NotEmpty
    private String model;


    @NotNull
    @NotEmpty
    private CarType carType;


}