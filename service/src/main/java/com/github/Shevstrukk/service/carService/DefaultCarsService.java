package com.github.Shevstrukk.service.carService;

import com.github.Shevstrukk.dao.carDao.DefaultCarDAO;
import com.github.Shevstrukk.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DefaultCarsService implements CarsService {
    private static final Logger log = LoggerFactory.getLogger(DefaultCarsService.class);

    DefaultCarDAO defaultCarDAO;
    @Autowired
    public DefaultCarsService(DefaultCarDAO carsDAO) {   this.defaultCarDAO = carsDAO;    }


    public List<Car> getCars() {return defaultCarDAO.getListCar();   }

    public Car getCar(int id){return defaultCarDAO.getCar(id);}
}
