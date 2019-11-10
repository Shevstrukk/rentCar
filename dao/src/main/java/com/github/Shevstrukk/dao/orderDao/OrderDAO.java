package com.github.Shevstrukk.dao.orderDao;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;

public interface OrderDAO {
    public Order saveOrder(Order orderEntity, Car carEntity);
    public Order saveOrUpdate(Order orderEntity, Car carEntity);
    public Person getOrderList(int id);
}
