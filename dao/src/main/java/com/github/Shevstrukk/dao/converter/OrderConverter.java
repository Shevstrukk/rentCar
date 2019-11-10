package com.github.Shevstrukk.dao.converter;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    public static OrderEntity toEntity(Order order){
        if(order == null){
            return null;
        }
final OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setPrice(order.getPrice());
        orderEntity.setRentDay(order.getRentDay());
        orderEntity.setPerson(PersonConverter.toEntity(order.getPerson1()));
        orderEntity.setCarEntities(CarConverter.toListEntityCar(order.getCars()));
        return orderEntity;
    }
    public static Order fromEntity(OrderEntity orderEntity){
        if(orderEntity == null){
            return  null;
        }
        return  new Order(
                orderEntity.getId(),
                orderEntity.getRentDay(),
                orderEntity.getPrice(),
                PersonConverter.fromEntity(orderEntity.getPerson()),
                CarConverter.fromListEntityCar(orderEntity.getCarEntities())
        );
    }

    public static List<OrderEntity> toListOrderEntity(List<Order> orderList){
        List<OrderEntity> orderEntityList = new ArrayList<>();
        for(Order elem: orderList){
            orderEntityList.add(OrderConverter.toEntity(elem));
        }
        return orderEntityList;
    }
    public static List<Order> fromListOrderEntity(List<OrderEntity> orderEntityList){
        List<Order> orderList = new ArrayList<>();
        for(OrderEntity elem: orderEntityList){
            orderList.add(OrderConverter.fromEntity(elem));
        }
        return orderList;
    }
}
