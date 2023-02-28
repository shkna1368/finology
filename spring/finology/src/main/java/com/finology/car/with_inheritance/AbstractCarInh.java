package com.finology.car.with_inheritance;

import com.finology.car.common.CarType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
@NoRepositoryBean

public interface AbstractCarInh <T extends CarInh>
        extends CrudRepository<T, Long> {

    List<T> findByCarType(CarType carType);
}
