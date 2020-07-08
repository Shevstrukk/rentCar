package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.model.Address;
import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.model.Order;
import com.github.shevstrukk.model.User;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DefaultOrderDaoTest {

    @Test
    public void saveOrUpdate() {
        Address addressFromDB = DefaultAddressDao.getInstance().saveAddress( new Address(null, "Belarus", "Bobruisk", "Ulianova", 49, 5, null));
        User user = new User(null, "dimon", "dimon", "333", null, addressFromDB, null);
        User userDB = DefaultUserDao.getInstance().save(user);
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carNew = DefaultCarDao.getInstance().saveCar(car);
        List<Car> carList = new ArrayList<>();
        Order order = new Order( null , 5, 100, LocalDateTime.now(), userDB, carList);
        Order fromDB = DefaultOrderDao.getInstance().saveOrUpdate(order, carNew.getId());
        assertNotNull(fromDB);
    }

}