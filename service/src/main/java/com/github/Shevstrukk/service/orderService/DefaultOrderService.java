package com.github.Shevstrukk.service.orderService;

import com.github.Shevstrukk.dao.entity.Car;
import com.github.Shevstrukk.dao.entity.Order;
import com.github.Shevstrukk.dao.orderDao.DefaultOrderDAO;
import com.github.Shevstrukk.dao.orderDao.OrderDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultOrderService implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(DefaultOrderService.class);

    private OrderDAO orderDAO = DefaultOrderDAO.getInstance();

    private OrderService orderService = DefaultOrderService.getInstance();

    public DefaultOrderService() {}

    private static class SingletonHolder {
        static final OrderService HOLDER_INSTANCE = new DefaultOrderService();
    }

    public static OrderService getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public Order saveOrder(Order order, Car car) { return orderDAO.saveOrder(order, car);    }
    public Order saveOrUpdate(Order order, Car car) { return orderDAO.saveOrder(order, car);    }
}
