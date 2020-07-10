package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.CarDao;
import com.github.shevstrukk.dao.RentalPeriodDao;
import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.model.RentalPeriod;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class DefaultRentalPeriodDaoTest {
    RentalPeriodDao rentalPeriodDao = new DefaultRentalPeriodDao();
    CarDao carDao = new DefaultCarDao();

    @Test
    public void save() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carNew = carDao.saveCar(car);
        RentalPeriod rentalPeriod =new RentalPeriod( null, LocalDateTime.now(),LocalDateTime.now(), carNew);
        RentalPeriod fromDB = rentalPeriodDao.save(rentalPeriod, carNew.getId());
        assertNotNull(fromDB);
    }
}