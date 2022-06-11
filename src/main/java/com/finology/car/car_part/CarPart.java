package com.finology.car.car_part;


import com.finology.car.car.Car;
import com.finology.car.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_PARTS")
@Data
public class CarPart extends BaseEntity {

    @NotNull
    @Column(name = "TITLE")
    private String title;



    @NotNull
    @Column(name = "IS_REPAIRABLE")
    private Boolean isRepairable;

        @NotNull
        @ManyToOne
        @JoinColumn(name = "CAR_ID")
       private Car car;



}
