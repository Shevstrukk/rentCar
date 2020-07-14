package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.CarDao;
import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.service.CarsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class DefaultCarsService implements CarsService {
    private static final Logger log = LoggerFactory.getLogger(DefaultCarsService.class);

    private final CarDao carsDAO;

    public DefaultCarsService(CarDao carsDAO) {
        this.carsDAO = carsDAO;
    }

    public List<Car> getCars() {return carsDAO.getListCar();   }

    public Car getCar(Long id){return carsDAO.getCar(id);}


    public void deleteCar(Long id) {
        carsDAO.deleteCar(id);
    }

    public Car saveCar(Car car){
        return carsDAO.saveCar(car);
    }
}
