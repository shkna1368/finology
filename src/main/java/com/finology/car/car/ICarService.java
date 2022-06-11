package com.finology.car.car;

import java.math.BigDecimal;
import java.util.List;

public interface ICarService {

    Car save(Car car);
    Car update(Car car);


    Car getById(Long id);
    void delete(Long id);

    List<Car> getByCarType(CarType carType);


}
