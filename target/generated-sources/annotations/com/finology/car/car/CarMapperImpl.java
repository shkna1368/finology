package com.finology.car.car;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-11T11:01:22+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car toCar(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( carDTO.getId() );
        car.setVersion( carDTO.getVersion() );
        car.setCreatedDate( carDTO.getCreatedDate() );
        car.setCreatedBy( carDTO.getCreatedBy() );
        car.setLastModifiedDate( carDTO.getLastModifiedDate() );
        car.setLastModifiedBy( carDTO.getLastModifiedBy() );
        car.setModel( carDTO.getModel() );
        car.setCarType( carDTO.getCarType() );

        return car;
    }

    @Override
    public CarDTO toCarDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        carDTO.setId( car.getId() );
        carDTO.setVersion( car.getVersion() );
        carDTO.setCreatedDate( car.getCreatedDate() );
        carDTO.setCreatedBy( car.getCreatedBy() );
        carDTO.setLastModifiedDate( car.getLastModifiedDate() );
        carDTO.setLastModifiedBy( car.getLastModifiedBy() );
        carDTO.setModel( car.getModel() );
        carDTO.setCarType( car.getCarType() );

        return carDTO;
    }

    @Override
    public List<CarDTO> toDTOs(List<Car> cars) {
        if ( cars == null ) {
            return null;
        }

        List<CarDTO> list = new ArrayList<CarDTO>( cars.size() );
        for ( Car car : cars ) {
            list.add( toCarDTO( car ) );
        }

        return list;
    }
}
