package com.github.Shevstrukk.dao.orderDao;

import com.github.Shevstrukk.dao.AuthUsersDAO;
import com.github.Shevstrukk.dao.PersonDAO;
import com.github.Shevstrukk.dao.carDao.CarsDAO;
import com.github.Shevstrukk.dao.config.DaoConfig;
import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.phonedao.PhoneDAO;
import com.github.Shevstrukk.model.AuthUser;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class DefaultOrderDAOTest {
@Autowired
private OrderDAO orderDao;
@Autowired
 private CarsDAO carDao;
@Autowired
    AuthUsersDAO authUsersDAO;
@Autowired
    PersonDAO personDAO;
@Autowired
    SessionFactory sessionFactory;

    @Test
    public void saveOrder() {
        Car car = new Car(null, "honda", 2019, "black", 6, "no crash", null);
        List<Car> cars = new ArrayList<>();
        Car carNew = carDao.create(car);
        cars.add(carNew);
        Order order = new Order(null, 5, 25,null, cars );
        Order orderSave = orderDao.saveOrder(order);
        assertNotNull(orderSave);
        assertEquals(order.getPrice(),orderSave.getPrice());
    }

    @Test
    public void saveUpdate() {
        Car car = new Car(null, "honda",
                2019, "black", 6, "no crash", null);
        Car car1 = new Car(null, "bmv",
                2019, "black", 10, "no crash", null);
        List<Car> cars = new ArrayList<>();
        Car carDB = carDao.create(car);
        cars.add(carDB);
        Order order = new Order(null, 5, 25,null, cars );
        Order orderSave = orderDao.saveOrder(order);
        Car carDB1 = carDao.create(car);
        Order orderUpdate = orderDao.saveUpdate(orderSave, carDB1.getId());
        assertNotNull(orderSave);
        assertNotEquals(orderSave, orderUpdate);
    }

    @Test
    public void deleteOrder() {
        AuthUser authUser = new AuthUser(null, "sd", "sd", "user", null);
        AuthUser saveAuthUser = authUsersDAO.saveOrUpdateAuthUser(authUser);
        Person person = new Person(null,"sd", "sd", authUser,
                null, null,null );
        Car car = new Car(null, "honda",
                2019, "black", 6, "no crash", null);
        List<Car> cars = new ArrayList<>();
        Car carDB = carDao.create(car);
        cars.add(carDB);
        Order order = new Order(null, 5, 25,person, cars );
        Order orderSave = orderDao.saveOrder(order);
        orderDao.deleteOrder(orderSave.getId());
        OrderEntity orderEntity = sessionFactory.getCurrentSession().get(OrderEntity.class, orderSave.getId());
        assertNotNull(orderSave);
        assertNull(orderEntity);
    }
}