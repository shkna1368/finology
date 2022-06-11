package com.finology.car.car;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    Car toCar(CarDTO carDTO);
    CarDTO toCarDTO(Car car);
    List<CarDTO> toDTOs(List<Car> cars);

}
