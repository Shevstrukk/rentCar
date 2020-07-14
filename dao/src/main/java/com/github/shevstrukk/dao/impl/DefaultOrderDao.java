package com.github.shevstrukk.dao.impl;


import com.github.shevstrukk.dao.OrderDao;
import com.github.shevstrukk.dao.converter.OrderConverter;
import com.github.shevstrukk.dao.entity.CarEntity;
import com.github.shevstrukk.dao.entity.OrderEntity;
import com.github.shevstrukk.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DefaultOrderDao implements OrderDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultOrderDao.class);
    private final SessionFactory factory;

    public DefaultOrderDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Order saveOrUpdate(Order order, Long carId) {
        OrderEntity orderEntity = OrderConverter.toEntity(order);
        final Session session = factory.getCurrentSession();
        CarEntity carEntity = session.get(CarEntity.class, carId);
        orderEntity.getCarEntityList().add(carEntity);
        carEntity.getOrderEntityList().add(orderEntity);
        session.saveOrUpdate(orderEntity);
        return OrderConverter.fromEntityCreateOrder(orderEntity);
    }
}