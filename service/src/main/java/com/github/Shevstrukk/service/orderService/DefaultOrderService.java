package com.github.Shevstrukk.service.orderService;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.orderDao.DefaultOrderDAO;
import com.github.Shevstrukk.dao.orderDao.OrderDAO;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
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

    public Order saveOrder(Order orderEntity, int id) { return orderDAO.saveOrder(orderEntity, id);    }
    public Order saveUpdate(Order orderEntity, int id) { return orderDAO.saveUpdate(orderEntity, id);    }

    public Person getOrderList(int id) { return orderDAO.getOrderList(id);}
    public  Person deleteOrder(int id, int personId) { return orderDAO.deleteOrder(id, personId);}
}

