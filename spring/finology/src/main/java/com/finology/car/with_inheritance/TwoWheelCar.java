package com.finology.car.with_inheritance;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity(name="two_wheel")
@Data
@DiscriminatorValue("TWO_WHEELS")

public class TwoWheelCar extends CarInh {

    @NotNull
    @Column(name = "wheel_size")
    private Integer wheelSize;









}
