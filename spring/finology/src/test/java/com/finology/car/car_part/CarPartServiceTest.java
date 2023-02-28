package com.finology.car.car_part;

import com.finology.car.without_inheritance.car.Car;
import com.finology.car.common.CarType;
import com.finology.car.without_inheritance.car.CarService;
import com.finology.car.without_inheritance.car.ICarService;
import com.finology.car.without_inheritance.car_part.CarPart;
import com.finology.car.without_inheritance.car_part.CarPartRepository;
import com.finology.car.without_inheritance.car_part.CarPartService;
import com.finology.car.without_inheritance.car_part.ICarPartService;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarPartServiceTest {
    @Mock
    CarPartRepository carPartRepository;

    @Mock
    CarService carService;


    @InjectMocks
    CarPartService carPartService;

    @BeforeEach
    void initUseCase() {
        carPartService = new CarPartService(carPartRepository, carService);
    }

    @Order(1)
    @Test
    public void save() throws Exception {

        Car car = new Car();
        String model = "m1";
        CarType carType = CarType.SPORT;
        car.setModel(model);
        car.setCarType(carType);

        when(carService.getById(any(Long.class))).thenReturn(car);
        var savedCar = carService.getById(1l);

        CarPart carPart1 = new CarPart();
        String title2 = "tit2";
        carPart1.setTitle(title2);
        carPart1.setCar(savedCar);
        carPart1.setIsRepairable(true);


        //  when(carPartRepository.existsByTitle(any(String.class))).thenReturn(false);


        when(carPartRepository.save(any(CarPart.class))).thenReturn(carPart1);


        var savedCarPart = carPartService.save(carPart1);


        assertNotNull(savedCarPart);

        assertEquals(savedCarPart.getTitle(), carPart1.getTitle());
        assertEquals(savedCarPart.getIsRepairable(), carPart1.getIsRepairable());
    }

    @Order(2)
    @Test
    public void filterByCar() throws Exception {

        Car car = new Car();
        car.setId(1l);
        String model = "m1";
        CarType carType = CarType.SPORT;
        car.setModel(model);
        car.setCarType(carType);


        CarPart carPart1 = new CarPart();
        carPart1.setCar(car);
        String title2 = "tit2";
        carPart1.setTitle(title2);
        carPart1.setCar(car);
        carPart1.setIsRepairable(true);


        CarPart carPart2 = new CarPart();
        carPart2.setCar(car);
        String title3 = "tit3";
        carPart2.setTitle(title3);
        carPart2.setCar(car);
        carPart2.setIsRepairable(true);


        List<CarPart> carParts = List.of(carPart1, carPart2);


        when(carService.getById(any(Long.class))).thenReturn(car);

        when(carPartRepository.findAllByCar(any(Car.class))).thenReturn(carParts);


        List<CarPart> carPartList = carPartService.getByCar(car.getId());

        assertFalse(carPartList.isEmpty());
        assertNotNull(carPartList.get(0));
    }


}

