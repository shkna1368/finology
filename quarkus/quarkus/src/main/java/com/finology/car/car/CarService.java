package com.finology.car.car;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CarService {


    @ConfigProperty(name = "custom.error.msg.usernotfound")
    String notFoundException;



    @ConfigProperty(name = "custom.error.msg.duplicate")
    String duplicateException;


    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<Car> findAll() {
        return carRepository.findAll().list();
    }



    public void delete( long id) {
        carRepository.deleteById(id);
    }

    public void create( Car car) {
         carRepository.persist(car);
    }

    public Car getById(Long id){


       return carRepository.findById(id);
    }


    public List<Car> findByCarType( CarType carType) {
        return carRepository.findAllByCarType(carType);
    }
}
