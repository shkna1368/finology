package com.finology.car.with_inheritance;


import com.finology.car.common.CarType;
import com.finology.car.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.envers.Audited;


@Entity
@Data
@Audited
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CAR_TYPE",discriminatorType = DiscriminatorType.STRING)


public abstract class CarInh extends BaseEntity {

    @NotNull
    @Column(name = "MODEL")
    private String model;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "CAR_TYPE",insertable=false,updatable = false)
    private CarType carType;





}
