package com.finology.car.without_inheritance.car;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    Car toCar(CarDTO carDTO);
    CarDTO toCarDTO(Car car);
    List<CarDTO> toDTOs(List<Car> cars);

}
