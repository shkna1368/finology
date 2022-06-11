package com.finology.car.car_part;

import com.finology.car.car.Car;
import com.finology.car.car.CarType;

import java.util.List;

public interface ICarPartService {

    CarPart save(CarPart carPart);
    CarPart update(CarPart carPart);


    CarPart getById(Long id);
    void delete(Long id);

    List<CarPart> getByCar(Long carId);


}
