package com.finology.car.car_part;

import com.finology.car.without_inheritance.car.Car;
import com.finology.car.without_inheritance.car.CarRepository;
import com.finology.car.common.CarType;
import com.finology.car.without_inheritance.car_part.CarPart;
import com.finology.car.without_inheritance.car_part.CarPartRepository;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarPartRepositoryTest {


    @Autowired
    CarPartRepository carPartRepository;



    @Autowired
    CarRepository carRepository;






   @BeforeEach
    void initUseCase() {

       Car car=new Car();
       String model="m1";
       CarType carType=CarType.SPORT;
       car.setModel(model);
       car.setCarType(carType);
       Car savedCar=carRepository.save(car);


       CarPart carPart=new CarPart();
       carPart.setCar(car);
       String title="tit1";
       carPart.setTitle(title);
       carPart.setCar(savedCar);
       carPart.setIsRepairable(true);

       carPartRepository.save(carPart);




    }

    @AfterEach
    public void destroyAll(){
        carPartRepository.deleteAll();
    }

    @Order(1)
    @Test
    public void save() throws Exception {
        Car car=new Car();
        String model="m2";
        CarType carType=CarType.SPORT;
        car.setModel(model);
        car.setCarType(carType);
        Car savedCar=carRepository.save(car);


        CarPart carPart=new CarPart();
        carPart.setCar(car);
        String title="tit2";
        carPart.setTitle(title);
        carPart.setCar(savedCar);
        carPart.setIsRepairable(true);

       var savedPart= carPartRepository.save(carPart);


        assertNotNull(savedPart);
        Assert.assertEquals(carPart.getTitle(),savedPart.getTitle());
    }

    @Order(2)
    @Test
    public void getPartsByCar() throws Exception {
      List<CarPart> carParts= (List<CarPart>) carPartRepository.findAll();


        List<CarPart> all = carPartRepository.findAllByCar(carParts.get(0).getCar());

        assertNotNull(all.get(0));
    }



}
