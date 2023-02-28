package com.finology.car;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

import com.finology.car.car.CarRepository;
import com.finology.car.car_parts.CarPartRepository;
import com.finology.car.car.Car;
import com.finology.car.car.CarType;
import com.finology.car.car_parts.CarPart;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");
    private final CarRepository carRepository;
    private final CarPartRepository carPartRepository;

    public AppLifecycleBean(CarRepository carRepository,CarPartRepository carPartRepository) {
        this.carRepository = carRepository;
        this.carPartRepository=carPartRepository;
    }

    @Transactional
    void onStart(@Observes StartupEvent ev) {
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

            carRepository.persist(c1);
            carRepository.persist(c2);
            carRepository.persist(c3);
            carRepository.persist(c4);
            carRepository.persist(c5);
            carRepository.persist(c6);


            CarPart carPart1 = new CarPart();
            carPart1.setTitle("part1");
            carPart1.setIsRepairable(true);
            carPart1.setCar(c1);
            carPartRepository.persist(carPart1);

            CarPart carPart2 = new CarPart();
            carPart2.setTitle("part2");
            carPart2.setIsRepairable(true);
            carPart2.setCar(c1);
            carPartRepository.persist(carPart2);


            CarPart carPart3 = new CarPart();
            carPart3.setTitle("part3");
            carPart3.setIsRepairable(true);
            carPart3.setCar(c2);
            carPartRepository.persist(carPart3);


            CarPart carPart4 = new CarPart();
            carPart4.setTitle("part4");
            carPart4.setIsRepairable(true);
            carPart4.setCar(c3);
            carPartRepository.persist(carPart4);
    }
    }

    void onStop(@Observes ShutdownEvent ev) {
        System.out.println("The application is stopping...");

    }

}