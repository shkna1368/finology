package com.finology.car.without_inheritance.car_part;


import com.finology.car.without_inheritance.car.Car;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Shabab
 */
@Repository
public interface CarPartRepository extends CrudRepository<CarPart, Long> {

    @EntityGraph(attributePaths = {"car"})
    List<CarPart> findAllByCar(Car car);

    Boolean existsByTitle(String title);
    Boolean existsByTitleAndIdNot(String title,long id);



}
