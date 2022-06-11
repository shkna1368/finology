package com.finology.car.car_part;


import com.finology.car.car.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Shabab
 */
@Repository
public interface CarPartRepository extends PagingAndSortingRepository<CarPart, Long> {


    List<CarPart> findAllByCar(Car car);

    Boolean existsByTitle(String title);
    Boolean existsByTitleAndIdNot(String title,long id);



}
