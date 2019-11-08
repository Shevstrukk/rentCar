package com.github.Shevstrukk.service.orderService;

import com.github.Shevstrukk.dao.entity.Car;
import com.github.Shevstrukk.dao.entity.Order;
import com.github.Shevstrukk.dao.entity.Person;

import java.util.List;

public interface OrderService {
    public Order saveOrder(Order order, Car car);
    public Order saveOrUpdate(Order order, Car car);
    public Person getOrderList(int id);
}
