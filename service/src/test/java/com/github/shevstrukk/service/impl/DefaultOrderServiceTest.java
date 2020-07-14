package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.OrderDao;
import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.model.Order;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultOrderServiceTest {
    @Mock
    OrderDao orderDao;
    @InjectMocks
    DefaultOrderService orderService;

    @Test
    public void save() {
        List<Car> cars = new ArrayList<>();
        Car car = new Car(5l, "reno", "scenic", 2010, "black",
                "disel", 5, "ok", null, null);
        cars.add(car);
        Order order = new Order(null,3, 5, LocalDateTime.now(), null,cars );
        when(orderDao.saveOrUpdate(order,car.getId())).thenReturn(order);
        Order order1 = orderService.save(order, car.getId());
        assertNotNull(order1);
        assertEquals(order1.getPriceSum(), order.getPriceSum());
    }
}