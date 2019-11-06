package com.github.Shevstrukk.dao.orderDao;

import com.github.Shevstrukk.dao.entity.Car;
import com.github.Shevstrukk.dao.entity.Order;

public interface OrderDAO {
    public Order saveOrder(Order order, Car car);
}
