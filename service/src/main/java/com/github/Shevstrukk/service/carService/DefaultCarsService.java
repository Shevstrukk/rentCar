package com.github.Shevstrukk.service.carService;

import com.github.Shevstrukk.dao.carDao.CarsDAO;
import com.github.Shevstrukk.dao.carDao.DefaultCarDAO;
import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DefaultCarsService implements CarsService {
    private static final Logger log = LoggerFactory.getLogger(DefaultCarsService.class);

    private CarsDAO carsDAO = DefaultCarDAO.getInstance();
    public DefaultCarsService() {}

    public DefaultCarsService(CarsDAO carsDAO) {   this.carsDAO = carsDAO;    }

    private static class SingletonHolder {
        static final CarsService HOLDER_INSTANCE = new DefaultCarsService();    }

    public static CarsService getInstance() {   return SingletonHolder.HOLDER_INSTANCE;    }

    public List<Car> getCars() {return carsDAO.getListCar();   }

    public Car getCar(int id){return carsDAO.getCar(id);}
}
