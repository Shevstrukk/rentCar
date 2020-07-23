package com.github.shevstrukk.service;

import com.github.shevstrukk.model.Order;

public interface OrderService {
    public Order save(Order order, Long carId);
    void deleteOrder(Long id);
}
