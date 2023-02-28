package com.finology.car.with_inheritance;

import com.finology.car.common.CarType;

import java.util.List;

public interface ICarInhService {

    List<? extends CarInh> getCarByType(CarType carType);
}
