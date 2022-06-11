package com.finology.car.car_part;


import com.finology.car.car.Car;
import com.finology.car.car.CarDTO;
import com.finology.car.car.CarMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = CarMapper.class)
public interface CarPartMapper {

    CarPart toCarPart(CarPartDTO carPartDTO);
    CarPartDTO toCarPartDTO(CarPart carPart);
    List<CarPartDTO> toDTOs(List<CarPart> carParts);

}
