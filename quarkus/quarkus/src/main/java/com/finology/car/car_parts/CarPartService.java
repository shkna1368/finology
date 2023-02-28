package com.finology.car.car_parts;

import com.finology.car.car.CarService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CarPartService {


    @ConfigProperty(name = "custom.error.msg.usernotfound")
    String notFoundException;



    @ConfigProperty(name = "custom.error.msg.duplicate")
    String duplicateException;


    private final CarPartRepository carPartRepository;
    private final CarService carService;

    public CarPartService(CarPartRepository carPartRepository,CarService carService) {
        this.carPartRepository = carPartRepository;
        this.carService=carService;
    }



    public List<CarPart> findAll() {
        return carPartRepository.findAll().list();
    }



    public void delete( long id) {
        carPartRepository.deleteById(id);
    }

    public void create( CarPart carPart) {
var car=carService.getById(carPart.getCar().id);
carPart.setCar(car);

         carPartRepository.persist(carPart);
    }



    public List<CarPart> findByCar( Long carId) {


        var car=carService.getById(carId);

        return carPartRepository.findAllByCar(car);
    }
}
