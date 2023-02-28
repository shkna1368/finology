package com.finology.car.with_inheritance;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity(name="electrical")
@Data
@DiscriminatorValue("ELECTRICAL")



public class ElectricalCar extends CarInh {

    @NotNull
    @Column(name = "wat")
    private Integer wat;









}
