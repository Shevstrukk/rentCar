package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.model.RentalPeriod;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class DefaultRentalPeriodDaoTest {

    @Test
    public void save() {
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carNew = DefaultCarDao.getInstance().saveCar(car);
        RentalPeriod rentalPeriod =new RentalPeriod( null, LocalDateTime.now(),LocalDateTime.now(), carNew);
        RentalPeriod fromDB = DefaultRentalPeriodDao.getInstance().save(rentalPeriod, carNew.getId());
        assertNotNull(fromDB);
    }
}