package com.github.shevstrukk.service;

import com.github.shevstrukk.model.Car;

import java.util.List;

public interface CarsService {
    public List<Car> getCars();
    public Car getCar(Long id);
    public void deleteCar(Long id);
    public Car saveCar(Car car);
}
