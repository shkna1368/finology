package com.finology.car.without_inheritance.car_part;

import java.util.List;

public interface ICarPartService {

    CarPart save(CarPart carPart);
    CarPart update(CarPart carPart);


    CarPart getById(Long id);
    void delete(Long id);

    List<CarPart> getByCar(Long carId);


}
