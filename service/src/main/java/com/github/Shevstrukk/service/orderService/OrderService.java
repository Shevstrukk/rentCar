package com.github.Shevstrukk.service.orderService;

import com.github.Shevstrukk.dao.entity.Car;
import com.github.Shevstrukk.dao.entity.Order;

public interface OrderService {
    public Order saveOrder(Order order, Car car);
}
