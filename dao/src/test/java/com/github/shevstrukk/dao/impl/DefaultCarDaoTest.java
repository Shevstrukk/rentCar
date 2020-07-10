package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.CarDao;
import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.converter.CarConverter;
import com.github.shevstrukk.dao.entity.CarEntity;
import com.github.shevstrukk.model.Car;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DefaultCarDaoTest {
    CarDao carDao = new DefaultCarDao();

    @Test
    public void getListCar() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car car1 = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carNew = carDao.saveCar(car);
        Car carNew1 = carDao.saveCar(car1);
        List<Car> carList = carDao.getListCar();
        assertNotNull(carList);
    }

    @Test
    public void getCar() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carDB = carDao.saveCar(car);
        Car carGetId = CarConverter.fromEntity(HibernateUtil.getSession().get(CarEntity.class, carDB.getId()));
        assertNotNull(carGetId);
    }

    @Test
    public void deleteCar() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carDB = carDao.saveCar(car);
        carDao.deleteCar(carDB.getId());
        CarEntity carEntity = HibernateUtil.getSession().get(CarEntity.class, carDB.getId());
        assertNull(carEntity);
    }

    @Test
    public void saveCar() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carNew = carDao.saveCar(car);
       assertNotNull(carNew);
    }

    @Test
    public void updateCar() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carNew = carDao.saveCar(car);
        carNew.setCarModel("mers");
        carNew.setCarName("600");
        Car carUpdate = carDao.updateCar(carNew);
        assertNotNull(carUpdate);
        assertEquals(carNew.getId(), carUpdate.getId() );
        assertEquals(carUpdate.getCarModel(), "mers");
        assertEquals(carUpdate.getCarName(), "600");

    }
}