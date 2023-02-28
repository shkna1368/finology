package com.finology.car.without_inheritance.car;

import com.finology.car.common.CarType;
import com.finology.car.exception.ConflictException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Shabab
 */

@Slf4j
@Service
@AllArgsConstructor
public class CarService implements  ICarService{

  private final   CarRepository carRepository;


    @Override
    public Car save(Car car) {

        boolean existTile=carRepository.existsByModel(car.getModel());

        if (Boolean.TRUE==existTile ) {
            throw new ConflictException("Duplicate title");


        }
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        boolean existTile=carRepository.existsByModelAndIdNot(car.getModel(),car.getId());

        if (Boolean.TRUE==existTile ) {
            throw new ConflictException("Duplicate title");


        }

       Car lastSavedCar=getById(car.getId());

       lastSavedCar.setCarType(car.getCarType());
       lastSavedCar.setModel(car.getModel());

        return carRepository.save(lastSavedCar);
    }

    @Override
    public Car getById(Long id) {
        Optional <Car> optionalCar=carRepository.findById(id);
        if(!optionalCar.isPresent()){

            throw new NotFoundException("Not found");
        }

        return optionalCar.get();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> getByCarType(CarType carType) {
        return carRepository.findAllByCarType(carType);
    }
}
