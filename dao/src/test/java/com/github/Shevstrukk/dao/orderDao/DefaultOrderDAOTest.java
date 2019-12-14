package com.github.Shevstrukk.dao.orderDao;

import com.github.Shevstrukk.dao.AuthUsersDAO;
import com.github.Shevstrukk.dao.PersonDAO;
import com.github.Shevstrukk.dao.carDao.CarsDAO;
import com.github.Shevstrukk.dao.config.DaoConfig;
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
        Car car = new Car(null, "honda",
                2019, "black", 6, "no crash", null);
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
    }

    @Test
    public void getOrderList() {
//        Order order = new Order(null, 5, 6, null, null);
//        Order order1 = new Order(null, 3, 6, null, null);
//        Order saveOrder = orderDao

    }

    @Test
    public void deleteOrder() {
//        AuthUser authUser = new AuthUser(null, "sd", "sd", "user", null);
//        AuthUser saveAuthUser = authUsersDAO.saveOrUpdateAuthUser(authUser);
//        Person person = new Person(null,"sd", "sd", saveAuthUser,
//                null, null,null );
//        Person savePerson = personDAO.insertPerson(person);
//        Order order = new Order(null, 5, 6, savePerson, null);
//        Order saveorder = orderDao.saveOrder(order);

    }
}