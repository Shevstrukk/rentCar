package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.converter.CarConverter;
import com.github.shevstrukk.dao.entity.CarEntity;
import com.github.shevstrukk.model.Car;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DefaultCarDaoTest {

    @Test
    public void getListCar() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car car1 = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carNew = DefaultCarDao.getInstance().saveCar(car);
        Car carNew1 = DefaultCarDao.getInstance().saveCar(car1);
        List<Car> carList = DefaultCarDao.getInstance().getListCar();
        assertNotNull(carList);
    }

    @Test
    public void getCar() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carDB = DefaultCarDao.getInstance().saveCar(car);
        Car carGetId = CarConverter.fromEntity(HibernateUtil.getSession().get(CarEntity.class, carDB.getId()));
        assertNotNull(carGetId);
    }

    @Test
    public void deleteCar() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carDB = DefaultCarDao.getInstance().saveCar(car);
        DefaultCarDao.getInstance().deleteCar(carDB.getId());
        CarEntity carEntity = HibernateUtil.getSession().get(CarEntity.class, carDB.getId());
        assertNull(carEntity);
    }

    @Test
    public void saveCar() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carNew = DefaultCarDao.getInstance().saveCar(car);
       assertNotNull(carNew);
    }

    @Test
    public void updateCar() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carNew = DefaultCarDao.getInstance().saveCar(car);
        carNew.setCarModel("mers");
        carNew.setCarName("600");
        Car carUpdate = DefaultCarDao.getInstance().updateCar(carNew);
        assertNotNull(carUpdate);
        assertEquals(carNew.getId(), carUpdate.getId() );
        assertEquals(carUpdate.getCarModel(), "mers");
        assertEquals(carUpdate.getCarName(), "600");

    }
}