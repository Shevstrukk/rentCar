package com.github.shevstrukk.dao.converter;

import com.github.shevstrukk.dao.entity.OrderEntity;
import com.github.shevstrukk.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    public static OrderEntity toEntity(Order order){
        if(order == null){
            return  null;
        }
        final OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setRentDay(order.getRentDay());
        orderEntity.setDate(order.getDate());
        orderEntity.setPriceSum(order.getPriceSum());
        orderEntity.setUserEntity(UserConverter.toEntity(order.getUser()));
        orderEntity.setCarEntityList(CarConverter.toListEntityCar(order.getCarList()));
        return orderEntity;

    }
    public static Order fromEntity(OrderEntity orderEntity){
        if(orderEntity == null){
            return null;
        }
        return new Order(
                orderEntity.getId(),
                orderEntity.getRentDay(),
                orderEntity.getPriceSum(),
                orderEntity.getDate(),
                null,
                CarConverter.fromListEntityCarGetOrder(orderEntity.getCarEntityList() ));
    }
    public static List<OrderEntity> toListOrderEntity(List<Order> orders){
        if(orders==null){
            return null;
        }
        List<OrderEntity> orderList = new ArrayList<>();
        for(Order elem: orders){
            orderList.add(OrderConverter.toEntity(elem));
        }
        return orderList;
    }
    public static List<Order> fromListEntityOrder(List<OrderEntity> ordersEntity){
        if(ordersEntity == null){
            return null;
        }
        List<Order> orderList = new ArrayList<>();
        for(OrderEntity elem: ordersEntity){
            orderList.add(OrderConverter.fromEntity(elem));
        }
        return orderList;
    }
    public static List<Order> fromListEntityOrderId(List<OrderEntity> ordersEntity){
        List<Order> orderList = new ArrayList<>();
        for(OrderEntity elem: ordersEntity){
            orderList.add(OrderConverter.fromEntityId(elem));
        }
        return orderList;
    }
    public static Order fromEntityId(OrderEntity orderEntity){
        if(orderEntity == null){
            return null;
        }
        return new Order(
                orderEntity.getId(),
                orderEntity.getRentDay(),
                orderEntity.getPriceSum(),
                orderEntity.getDate(),
                UserConverter.fromEntity(orderEntity.getUserEntity()),
                null);
    }
    public static Order fromEntityCreateOrder(OrderEntity orderEntity){
        if(orderEntity == null){
            return null;
        }
        return new Order(
                orderEntity.getId(),
                orderEntity.getRentDay(),
                orderEntity.getPriceSum(),
                orderEntity.getDate(),
                UserConverter.fromEntityCreateOrder(orderEntity.getUserEntity()),
                CarConverter.fromListEntityCarCreateOrder(orderEntity.getCarEntityList() ));
    }
}
