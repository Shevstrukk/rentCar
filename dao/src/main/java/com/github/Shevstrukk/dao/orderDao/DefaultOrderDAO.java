package com.github.Shevstrukk.dao.orderDao;

import com.github.Shevstrukk.dao.entity.Car;
import com.github.Shevstrukk.dao.entity.Order;
import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.util.EMUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultOrderDAO implements OrderDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultOrderDAO.class);
    public DefaultOrderDAO() {    }

    private static class SingletonHolder {
        static final OrderDAO HOLDER_INSTANCE = new DefaultOrderDAO();
    }

    public static OrderDAO getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public Order saveOrder(Order order, Car car) {
        Session session = EMUtil.getSession();
        session.beginTransaction();
        order.getCars().add(car);
        car.getOrders().add(order);
//        Person person = order.getPerson();
//        person.getOrders().add(order);
        session.saveOrUpdate(order);
        session.getTransaction().commit();
        session.close();
        return order;

    }
}
