package com.finology.car.without_inheritance.car;

import com.finology.car.common.BaseDTO;
import com.finology.car.common.CarType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CarDTO extends BaseDTO {


    @NotNull
    @NotEmpty
    @Schema(hidden = false,requiredMode = Schema.RequiredMode.REQUIRED)
    private String model;

    @NotNull
    @NotEmpty
   // @ApiModelProperty(required = true, hidden = false)
    @Schema(hidden = false,requiredMode = Schema.RequiredMode.REQUIRED)
    private CarType carType;

}
