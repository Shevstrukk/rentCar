package com.github.shevstrukk.dao;

import com.github.shevstrukk.model.Car;

import java.util.List;

public interface CarDao {
    public List<Car> getListCar();
    public Car getCar(Long id);
    public void deleteCar(Long id);
    public Car saveCar(Car car);
    public Car updateCar (Car car);
}
