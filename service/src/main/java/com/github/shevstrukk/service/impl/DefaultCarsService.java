package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.CarDao;
import com.github.shevstrukk.dao.impl.DefaultCarDao;
import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.service.CarsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DefaultCarsService implements CarsService {
    private static final Logger log = LoggerFactory.getLogger(DefaultCarsService.class);

    private CarDao carsDAO = DefaultCarDao.getInstance();
    public DefaultCarsService() {}

    public DefaultCarsService(CarDao carsDAO) {   this.carsDAO = carsDAO;    }

    private static class SingletonHolder {
        static final CarsService HOLDER_INSTANCE = new DefaultCarsService();    }

    public static CarsService getInstance() {   return SingletonHolder.HOLDER_INSTANCE;    }

    public List<Car> getCars() {return carsDAO.getListCar();   }

    public Car getCar(Long id){return carsDAO.getCar(id);}

    @Override
    public void deleteCar(Long id) {
        carsDAO.deleteCar(id);
    }
    public Car saveCar(Car car){
        return carsDAO.saveCar(car);
    }
}
