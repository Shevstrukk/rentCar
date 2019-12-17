package com.github.Shevstrukk.dao.converter;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarConverter {
    public static CarEntity toEntity(Car car){
        if(car == null){
            return  null;
        }
        final CarEntity carEntity = new CarEntity();
        if(car.getId() != null){
            carEntity.setId(car.getId());
        }
       // carEntity.setId(car.getId());
        carEntity.setCarName(car.getCarName());
        carEntity.setCarColor(car.getCarColor());
        carEntity.setCarYear(car.getCarYear());
        carEntity.setComment(car.getComment());
        carEntity.setPriceDay(car.getPriceDay());
        // carEntity.setOrderEntities(OrderConverter.toListOrderEntity(car.getOrders()));
        return carEntity;

    }
    public static Car fromEntity(CarEntity carEntity){
        if(carEntity == null){
            return null;
        }
        return new Car(
                carEntity.getId(),
                carEntity.getCarName(),
                carEntity.getCarYear(),
                carEntity.getCarColor(),
                carEntity.getPriceDay(),
                carEntity.getComment(),
                // OrderConverter.fromListOrderEntity(carEntity.getOrderEntities())
                null
        );
    }
    public static List<CarEntity> toListEntityCar(List<Car> cars){
        List<CarEntity> carEntityList = new ArrayList<>();
        for(Car elem: cars){
            carEntityList.add(CarConverter.toEntity(elem));
        }
        return carEntityList;
    }
    public static List<Car> fromListEntityCar(List<CarEntity> carsEntity){
        List<Car> carList = new ArrayList<>();
        for(CarEntity elem: carsEntity){
            carList.add(CarConverter.fromEntity(elem));
        }
        return carList;

    }
}
