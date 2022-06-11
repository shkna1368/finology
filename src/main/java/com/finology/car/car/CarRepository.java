package com.finology.car.car;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Shabab
 */
@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {


    List<Car> findAllByCarType (CarType carType);
    Boolean existsByModel(String model);
    Boolean existsByModelAndIdNot(String model,long id);




}
