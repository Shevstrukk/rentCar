package com.github.Shevstrukk.dao.carDao;

import com.github.Shevstrukk.dao.entity.Car;

import java.util.List;

public interface CarsDAO {
    public List<Car> getListCar();
    public Car getCar(int id);
}
