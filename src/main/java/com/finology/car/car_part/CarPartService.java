package com.finology.car.car_part;

import com.finology.car.car.Car;
import com.finology.car.car.CarRepository;
import com.finology.car.car.CarType;
import com.finology.car.car.ICarService;
import com.finology.car.exception.ConflictException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
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
public class CarPartService implements ICarPartService {

  private final CarPartRepository carPartRepository;
  private final ICarService carService;


    @Override
    public CarPart save(CarPart carPart) {

        boolean existTile=carPartRepository.existsByTitle(carPart.getTitle());

        if (Boolean.TRUE==existTile ) {
            throw new ConflictException("Duplicate title");


        }



 Car car=getCarById(carPart.getCar().getId());
 carPart.setCar(car);

        return carPartRepository.save(carPart);
    }

    @Override
    public CarPart update(CarPart carPart) {


        boolean existTile=carPartRepository.existsByTitleAndIdNot(carPart.getTitle(),carPart.getId());

        if (Boolean.TRUE==existTile ) {
            throw new ConflictException("Duplicate title");


        }
        Car car=getCarById(carPart.getCar().getId());

        CarPart lastSavedCarPart=getById(car.getId());

        lastSavedCarPart.setTitle(carPart.getTitle());
        lastSavedCarPart.setIsRepairable(carPart.getIsRepairable());
        lastSavedCarPart.setCar(car);

        return carPartRepository.save(lastSavedCarPart);
    }

    @Override
    public CarPart getById(Long id) {
        Optional <CarPart> optionalCarPart=carPartRepository.findById(id);
       if(!optionalCarPart.isPresent()){

           throw new NotFoundException("Not found");
       }

        return optionalCarPart.get();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        carPartRepository.deleteById(id);
    }

    @Override
    public List<CarPart> getByCar(Long carId) {
        Car car=getCarById(carId);
        return carPartRepository.findAllByCar(car);
    }


    private Car getCarById(Long id){

        return carService.getById(id);

    }

}
