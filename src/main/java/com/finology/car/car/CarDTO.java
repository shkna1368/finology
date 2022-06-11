package com.finology.car.car;

import com.finology.car.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
public class CarDTO extends BaseDTO {


    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)
    private String model;

    @NotNull
    @NotEmpty
    @ApiModelProperty(required = true, hidden = false)

    private CarType carType;

}
