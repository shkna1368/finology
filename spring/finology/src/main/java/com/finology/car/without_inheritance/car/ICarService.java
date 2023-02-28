package com.finology.car.without_inheritance.car;

import com.finology.car.common.CarType;

import java.util.List;

public interface ICarService {

    Car save(Car car);
    Car update(Car car);


    Car getById(Long id);
    void delete(Long id);

    List<Car> getByCarType(CarType carType);


}
