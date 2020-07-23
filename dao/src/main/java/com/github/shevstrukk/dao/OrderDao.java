package com.github.shevstrukk.dao;

import com.github.shevstrukk.model.Order;

public interface OrderDao {
    public Order saveOrUpdate(Order order, Long carId);
    void deleteOrder(Long id);
}
