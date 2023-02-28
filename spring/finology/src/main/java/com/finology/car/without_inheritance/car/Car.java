package com.finology.car.without_inheritance.car;


import com.finology.car.common.BaseEntity;
import com.finology.car.common.CarType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.envers.Audited;



@Entity
@Table(name = "T_CARS")
@Data
@Audited
public class Car extends BaseEntity {

    @NotNull
    @Column(name = "MODEL")
    private String model;



    @NotNull
    @Column(name = "CAR_TYPE")
    @Enumerated(value = EnumType.STRING)
    private CarType carType;






}
