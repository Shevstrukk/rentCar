package com.github.Shevstrukk.service.carService;


import com.github.Shevstrukk.model.Car;

import java.util.List;

public interface CarsService {
    public List<Car> getCars();
    public Car getCar(int id);
    public Car create(Car car);
    public Car update(Car car);
    public void delete(int id);
}
