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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultOrderService implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(DefaultOrderService.class);
@Autowired
DefaultOrderDAO defaultOrderDAO;

    public Order saveOrder(Order orderEntity, int id) { return defaultOrderDAO.saveOrder(orderEntity, id);    }
    public Order saveUpdate(Order orderEntity, int id) { return defaultOrderDAO.saveUpdate(orderEntity, id);    }

    public Person getOrderList(int id) { return defaultOrderDAO.getOrderList(id);}
    public  void deleteOrder(int id, int personId) {  defaultOrderDAO.deleteOrder(id, personId);}
}

