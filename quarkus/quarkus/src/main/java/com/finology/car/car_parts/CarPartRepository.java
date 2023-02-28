package com.finology.car.car_parts;


import com.finology.car.car.Car;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CarPartRepository implements PanacheRepository<CarPart> {

    // put your custom logic here as instance methods

    public List<CarPart> findAllByCar(Car car){
        return find("car", car).list();
    }


}