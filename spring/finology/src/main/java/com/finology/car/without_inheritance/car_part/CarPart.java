package com.finology.car.without_inheritance.car_part;


import com.finology.car.without_inheritance.car.Car;
import com.finology.car.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



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
        @ManyToOne()
        @JoinColumn(name = "CAR_ID")
       private Car car;



}
