package com.finology.car.car_part;


import com.finology.car.car.CarDTO;
import com.finology.car.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class CarPartDTO extends BaseDTO {

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private String title;


    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private Boolean isRepairable;

       private CarDTO car;



}
