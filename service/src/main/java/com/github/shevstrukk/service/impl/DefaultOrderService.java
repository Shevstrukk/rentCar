package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.OrderDao;
import com.github.shevstrukk.dao.impl.DefaultOrderDao;
import com.github.shevstrukk.model.Order;
import com.github.shevstrukk.service.OrderService;

public class DefaultOrderService implements OrderService {
    private OrderDao orderDao = DefaultOrderDao.getInstance();
    public DefaultOrderService() {}

    public DefaultOrderService(OrderDao orderDao) {   this.orderDao = orderDao;    }

    private static class SingletonHolder {
        static final OrderService HOLDER_INSTANCE = new DefaultOrderService();    }

    public static OrderService getInstance() {   return SingletonHolder.HOLDER_INSTANCE;    }

    @Override
    public Order save(Order order, Long carId) {
        return orderDao.saveOrUpdate(order, carId);
    }
}
