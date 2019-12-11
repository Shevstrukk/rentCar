package com.github.Shevstrukk.dao.carDao;


import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.model.Car;

import java.util.List;

public interface CarsDAO {
    public List<Car> getListCar();
    public Car getCar(int id);
    public Car create(Car car);
    public Car update(Car car);
    public void delete(int id);
}
