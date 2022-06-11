package com.finology.car.car_part;

import com.finology.car.car.CarMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-11T11:01:22+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CarPartMapperImpl implements CarPartMapper {

    @Autowired
    private CarMapper carMapper;

    @Override
    public CarPart toCarPart(CarPartDTO carPartDTO) {
        if ( carPartDTO == null ) {
            return null;
        }

        CarPart carPart = new CarPart();

        carPart.setId( carPartDTO.getId() );
        carPart.setVersion( carPartDTO.getVersion() );
        carPart.setCreatedDate( carPartDTO.getCreatedDate() );
        carPart.setCreatedBy( carPartDTO.getCreatedBy() );
        carPart.setLastModifiedDate( carPartDTO.getLastModifiedDate() );
        carPart.setLastModifiedBy( carPartDTO.getLastModifiedBy() );
        carPart.setTitle( carPartDTO.getTitle() );
        carPart.setIsRepairable( carPartDTO.getIsRepairable() );
        carPart.setCar( carMapper.toCar( carPartDTO.getCar() ) );

        return carPart;
    }

    @Override
    public CarPartDTO toCarPartDTO(CarPart carPart) {
        if ( carPart == null ) {
            return null;
        }

        CarPartDTO carPartDTO = new CarPartDTO();

        carPartDTO.setId( carPart.getId() );
        carPartDTO.setVersion( carPart.getVersion() );
        carPartDTO.setCreatedDate( carPart.getCreatedDate() );
        carPartDTO.setCreatedBy( carPart.getCreatedBy() );
        carPartDTO.setLastModifiedDate( carPart.getLastModifiedDate() );
        carPartDTO.setLastModifiedBy( carPart.getLastModifiedBy() );
        carPartDTO.setTitle( carPart.getTitle() );
        carPartDTO.setIsRepairable( carPart.getIsRepairable() );
        carPartDTO.setCar( carMapper.toCarDTO( carPart.getCar() ) );

        return carPartDTO;
    }

    @Override
    public List<CarPartDTO> toDTOs(List<CarPart> carParts) {
        if ( carParts == null ) {
            return null;
        }

        List<CarPartDTO> list = new ArrayList<CarPartDTO>( carParts.size() );
        for ( CarPart carPart : carParts ) {
            list.add( toCarPartDTO( carPart ) );
        }

        return list;
    }
}
