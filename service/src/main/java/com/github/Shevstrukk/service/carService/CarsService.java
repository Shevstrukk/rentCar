package com.github.Shevstrukk.service.carService;

import com.github.Shevstrukk.dao.entity.Car;

import java.util.List;

public interface CarsService {
    public List<Car> getCars();
    public Car getCar(int id);
}
