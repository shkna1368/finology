package com.finology.car.car_parts;



import com.finology.car.car.CarMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi",uses= CarMapper.class)
public interface CarPartMapper {

   CarPart toEntity(CarPartDTO carPartDTO) ;
   CarPartDTO toDTO(CarPart carPart) ;
   List<CarPartDTO> toDTOs(List<CarPart> carParts) ;

}
