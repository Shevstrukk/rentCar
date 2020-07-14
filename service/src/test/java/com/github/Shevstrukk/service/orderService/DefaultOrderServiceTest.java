package com.github.Shevstrukk.service.orderService;

import com.github.Shevstrukk.dao.orderDao.OrderDAO;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultOrderServiceTest {
    @InjectMocks
    DefaultOrderService orderService;
    @Mock
    OrderDAO orderDAO;

    @Test
    public void saveOrder() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(null, "dsd", 99, "red", 5, "rr", null));
        Order order = new Order(null, 5, 12, null, null);
        when(orderDAO.saveOrder(order)).thenReturn(new Order(null, 5, 12, null, null));
        Order order1 = orderService.saveOrder(order);
        assertNotNull(order1);
    }

    @Test
    public void saveUpdate() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(null, "dsd", 99, "red", 5, "rr", null));
        Order order = new Order(null, 5, 12, new Person(1, "sdd",
                "sddd", null, null, null, null), cars);
        when(orderDAO.saveUpdate(order, 2)).thenReturn(new Order(null, 5, 19, new Person(1, "sdd",
                "sddd", null, null, null, null), cars));
        Order order1 = orderService.saveUpdate(order, 2);
        assertNotNull(order1);
        assertNotEquals(order1.getPrice(), order.getPrice());

    }
}