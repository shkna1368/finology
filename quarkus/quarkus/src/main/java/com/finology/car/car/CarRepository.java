package com.finology.car.car;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {

    // put your custom logic here as instance methods

    public List findAllByCarType(CarType carType){
        return find("carType", carType).list();
    }


}