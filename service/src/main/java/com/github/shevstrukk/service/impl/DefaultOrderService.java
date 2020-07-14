package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.OrderDao;
import com.github.shevstrukk.model.Order;
import com.github.shevstrukk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultOrderService implements OrderService {

    private final OrderDao orderDao;

    public DefaultOrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order save(Order order, Long carId) {
        return orderDao.saveOrUpdate(order, carId);
    }
}
