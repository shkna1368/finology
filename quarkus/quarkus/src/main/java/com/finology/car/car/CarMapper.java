package com.finology.car.car;



import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CarMapper {

   Car toEntity(CarDTO carDTO) ;
   CarDTO toDTO(Car car) ;
   List<CarDTO> toDTOs(List<Car> cars) ;

}
