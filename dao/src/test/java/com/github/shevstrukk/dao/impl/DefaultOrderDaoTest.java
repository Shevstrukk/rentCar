package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.AddressDao;
import com.github.shevstrukk.dao.CarDao;
import com.github.shevstrukk.dao.OrderDao;
import com.github.shevstrukk.dao.UserDAO;
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
    AddressDao addressDao = new DefaultAddressDao();
    UserDAO userDAO = new DefaultUserDao();
    CarDao carDao = new DefaultCarDao();
    OrderDao orderDao = new DefaultOrderDao();

    @Test
    public void saveOrUpdate() {
        Address addressFromDB = addressDao.saveAddress( new Address(null, "Belarus", "Bobruisk", "Ulianova", 49, 5, null));
        User user = new User(null, "dimon", "dimon", "333", null, addressFromDB, null);
        User userDB = userDAO.save(user);
        Car car = new Car(null, "reno", "scenic", 1999, "black",
                "бензин" , 3, "no crash", null, null);
        Car carNew = carDao.saveCar(car);
        List<Car> carList = new ArrayList<>();
        Order order = new Order( null , 5, 100, LocalDateTime.now(), userDB, carList);
        Order fromDB = orderDao.saveOrUpdate(order, carNew.getId());
        assertNotNull(fromDB);
    }

}