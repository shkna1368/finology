package com.finology.car.car_parts;

import com.finology.car.car.CarDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class CarPartDTO {


    private Long id;

    @NotNull
    @NotEmpty
    private String title;



    @NotNull
    @NotEmpty
    private Boolean isRepairable;

    @NotNull
    @NotEmpty
    private CarDTO car;
}