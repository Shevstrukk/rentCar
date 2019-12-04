package com.github.Shevstrukk.service.carService;

import com.github.Shevstrukk.dao.carDao.CarsDAO;
import com.github.Shevstrukk.dao.carDao.DefaultCarDAO;
import com.github.Shevstrukk.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DefaultCarsService implements CarsService {
    private static final Logger log = LoggerFactory.getLogger(DefaultCarsService.class);

   private  final CarsDAO carDAO;

    public DefaultCarsService(CarsDAO carDAO){ this.carDAO= carDAO;}
    @Override
    @Transactional
    public List<Car> getCars() {return carDAO.getListCar();   }
    @Override
    @Transactional
    public Car getCar(int id){return carDAO.getCar(id);}
}
