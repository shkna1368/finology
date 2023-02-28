package com.finology.car.without_inheritance.car_part;


import com.finology.car.without_inheritance.car.CarDTO;
import com.finology.car.common.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CarPartDTO extends BaseDTO {

    @NotNull
    @NotEmpty
    @Schema(hidden = false,requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;


    @NotNull
    @NotEmpty
    @Schema(hidden = false,requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean isRepairable;

       private CarDTO car;



}
