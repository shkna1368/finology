package com.finology.car.car;

import com.finology.car.without_inheritance.car.Car;
import com.finology.car.without_inheritance.car.CarRepository;
import com.finology.car.common.CarType;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
//unit test
import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarRepositoryTest {


    @Autowired
    CarRepository repository;




   @BeforeEach
    void initUseCase() {
       Car car=new Car();
       String model="m1";
       CarType carType=CarType.SPORT;
       car.setModel(model);
       car.setCarType(carType);
       repository.save(car);



    }

    @AfterEach
    public void destroyAll(){
        repository.deleteAll();
    }

    @Order(1)
    @Test
    public void save() throws Exception {
        Car car=new Car();
        String model="m2";
        CarType carType=CarType.SPORT;
        car.setModel(model);
        car.setCarType(carType);

        Car savedCar=  repository.save(car);


        assertNotNull(savedCar);
        Assert.assertEquals(car.getModel(),savedCar.getModel());
    }

    @Order(2)
    @Test
    public void getAllCar() throws Exception {



        List<Car> all = (List<Car>) repository.findAll();

        assertNotNull(all.get(0));
    }



}
