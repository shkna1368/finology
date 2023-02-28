package com.finology.car.without_inheritance.car_part;


import com.finology.car.without_inheritance.car.CarMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = CarMapper.class)
public interface CarPartMapper {

    CarPart toCarPart(CarPartDTO carPartDTO);
    CarPartDTO toCarPartDTO(CarPart carPart);
    List<CarPartDTO> toDTOs(List<CarPart> carParts);

}
