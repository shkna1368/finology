package com.finology.car.without_inheritance.car;


import com.finology.car.common.CarType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Shabab
 */
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {


    List<Car> findAllByCarType (CarType carType);
    Boolean existsByModel(String model);
    Boolean existsByModelAndIdNot(String model,long id);




}
