package com.github.Shevstrukk.service.orderService;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;

public interface OrderService {
     Order saveOrder(Order orderEntity);
     Order saveUpdate(Order orderEntity, int id);
//    public Person getOrderList(int id);
     void deleteOrder(int id);
     Order getOrder(int id);
}
