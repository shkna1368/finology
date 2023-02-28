package com.finology.car.with_inheritance;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity(name="sport")
@Data
@DiscriminatorValue("SPORT")
public class SportCar extends CarInh {

    @NotNull
    @Column(name = "ring_size")
    private Integer ringSize;









}
