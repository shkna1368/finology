package com.finology.car.car_parts;



import com.finology.car.car.Car;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class CarPart extends PanacheEntity {

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
