package com.finology.car.common;

import com.finology.car.car.Car;
import com.finology.car.car.CarRepository;
import com.finology.car.car.CarType;
import com.finology.car.car_part.CarPart;
import com.finology.car.car_part.CarPartRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Seeder implements ApplicationRunner {

  private final CarRepository carRepository;
  private final CarPartRepository carPartRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        if (carPartRepository.count()==0){
            Car c1=new Car();
            c1.setModel("M1");
            c1.setCarType(CarType.SPORT);

            Car c2=new Car();
            c2.setModel("M2");
            c2.setCarType(CarType.SPORT);

             Car c3=new Car();
            c3.setModel("M3");
            c3.setCarType(CarType.ELECTRICAL);

            Car c4=new Car();
            c4.setModel("M4");
            c4.setCarType(CarType.ELECTRICAL);

            Car c5=new Car();
            c5.setModel("M5");
            c5.setCarType(CarType.TWO_WHEELS);

            Car c6=new Car();
            c6.setModel("M6");
            c6.setCarType(CarType.TWO_WHEELS);

            Car savedCar1=carRepository.save(c1);
            Car savedCar2=carRepository.save(c2);
            Car savedCar3=carRepository.save(c3);
            Car savedCar4=carRepository.save(c4);
            Car savedCar5=carRepository.save(c5);
            Car savedCar6=carRepository.save(c6);


          if (carPartRepository.count()==0) {
              CarPart carPart1=new CarPart();
              carPart1.setTitle("part1");
              carPart1.setIsRepairable(true);
              carPart1.setCar(savedCar1);
              carPartRepository.save(carPart1);

               CarPart carPart2=new CarPart();
              carPart2.setTitle("part2");
              carPart2.setIsRepairable(true);
              carPart2.setCar(savedCar1);
              carPartRepository.save(carPart2);


                CarPart carPart3=new CarPart();
              carPart3.setTitle("part3");
              carPart3.setIsRepairable(true);
              carPart3.setCar(savedCar2);
              carPartRepository.save(carPart3);


                CarPart carPart4=new CarPart();
              carPart4.setTitle("part4");
              carPart4.setIsRepairable(true);
              carPart4.setCar(savedCar2);
              carPartRepository.save(carPart4);










          }




        }





    }
}
