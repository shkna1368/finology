package com.finology.car;

import com.finology.car.car.Car;
import com.finology.car.car.CarRepository;
import com.finology.car.car.CarType;
import com.finology.car.car_part.CarPartRepository;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarRepositoryTest {

    @Autowired
    CarRepository repository;



@Order(1)
      @Test
    public void save() throws Exception {

          Car car=new Car();
String model="m1";
CarType carType=CarType.SPORT;
car.setModel(model);
car.setCarType(carType);

Car savedCar =repository.save(car);


        assertNotNull(savedCar);
        Assert.assertEquals(model,savedCar.getModel());
        Assert.assertEquals(carType,savedCar.getCarType());
    }

    @Order(2)
    @Test
    public void findByCarTypeTest() throws Exception {



        List<Car> queryResult = (List<Car>) repository.findAllByCarType(CarType.SPORT);

        assertFalse(queryResult.isEmpty());
        assertNotNull(queryResult.get(0));
    }


}
