package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.OrderDao;
import com.github.shevstrukk.dao.converter.OrderConverter;
import com.github.shevstrukk.dao.entity.CarEntity;
import com.github.shevstrukk.dao.entity.OrderEntity;
import com.github.shevstrukk.model.Order;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultOrderDao implements OrderDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultOrderDao.class);
    public DefaultOrderDao() {
    }

    private static class SingletonHolder {
        static final OrderDao HOLDER_INSTANCE = new DefaultOrderDao();
    }

    public static OrderDao getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public Order saveOrUpdate(Order order, Long carId) {
        OrderEntity orderEntity = OrderConverter.toEntity(order);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        CarEntity carEntity = session.get(CarEntity.class, carId);
        orderEntity.getCarEntityList().add(carEntity);
        carEntity.getOrderEntityList().add(orderEntity);
        session.saveOrUpdate(orderEntity);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return OrderConverter.fromEntityCreateOrder(orderEntity);
    }
}
