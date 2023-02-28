package com.finology.car.car;

import com.finology.car.common.CarType;
import com.finology.car.without_inheritance.car.*;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarServiceTest {
    @Mock
    CarRepository repository;

    @InjectMocks
    CarService carService;

  @BeforeEach
    void initUseCase() {
        carService = new CarService(repository);
    }

    @Order(1)
    @Test
    public void save() throws Exception {

        Car car=new Car();
        String model="m1";
        CarType carType=CarType.SPORT;
        car.setModel(model);
        car.setCarType(carType);
        when(repository.save(any(Car.class))).thenReturn(car);
        Car savedPost =carService.save(car);
        assertNotNull(savedPost);
        Assert.assertEquals(car.getModel(),savedPost.getModel());
        Assert.assertEquals(car.getCarType(),savedPost.getCarType());
    }

    @Order(2)
    @Test
    public void filterByCarType() throws Exception {

        Car car1=new Car();
        String model="m1";
        CarType carType=CarType.SPORT;
        car1.setModel(model);
        car1.setCarType(carType);


        Car car2=new Car();
        String model2="m2";
        CarType carType2=CarType.SPORT;
        car2.setModel(model2);
        car2.setCarType(carType2);





        List<Car> cars=List.of(car1,car2);



        when(repository.findAllByCarType(any(CarType.class))).thenReturn(cars);


        List<Car> queryResult = carService.getByCarType(CarType.SPORT);

        Assertions.assertFalse(queryResult.isEmpty());
        assertNotNull(queryResult.get(0));
    }


}

