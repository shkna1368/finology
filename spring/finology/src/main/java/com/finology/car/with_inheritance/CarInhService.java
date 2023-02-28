package com.finology.car.with_inheritance;

import com.finology.car.common.CarType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CarInhService implements ICarInhService{

    private final ElectricalCarRepository electricalCarRepository;
    private final SportCarRepository sportCarRepository;
    private final TwoWheelCarRepository twoWheelCarRepository;


    @Override
    public List<? extends CarInh> getCarByType(CarType carType) {


        if (carType==CarType.ELECTRICAL){
            return  electricalCarRepository.findByCarType(carType);

        }

        else if (carType==CarType.TWO_WHEELS){
            return  twoWheelCarRepository.findByCarType(carType);

        }

        else {
            return  sportCarRepository.findByCarType(carType);

        }
    }
}
