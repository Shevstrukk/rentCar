package com.github.shevstrukk.dao.converter;

import com.github.shevstrukk.dao.entity.CarEntity;
import com.github.shevstrukk.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarConverter {

    public static CarEntity toEntity(Car car){
        if(car == null){
            return  null;
        }
        final CarEntity carEntity = new CarEntity();
        if(car.getId()!=null){
            carEntity.setId(car.getId());}
        carEntity.setCarModel(car.getCarModel());
        carEntity.setCarName(car.getCarName());
        carEntity.setCarYear(car.getCarYear());
        carEntity.setCarColor(car.getCarColor());
        carEntity.setCarFuel(car.getCarFuel());
        carEntity.setPriceDay(car.getPriceDay());
        carEntity.setComment(car.getComment());
        return carEntity;

    }
    public static Car createCarfromEntity(CarEntity carEntity){
        if(carEntity == null){
            return null;
        }
        return new Car(
                carEntity.getId(),
                carEntity.getCarModel(),
                carEntity.getCarName(),
                carEntity.getCarYear(),
                carEntity.getCarColor(),
                carEntity.getCarFuel(),
                carEntity.getPriceDay(),
                carEntity.getComment(),
                null,
                null   );
    }
    public static Car fromEntity(CarEntity carEntity){
        if(carEntity == null){
            return null;
        }
        return new Car(
                carEntity.getId(),
                carEntity.getCarModel(),
                carEntity.getCarName(),
                carEntity.getCarYear(),
                carEntity.getCarColor(),
                carEntity.getCarFuel(),
                carEntity.getPriceDay(),
                carEntity.getComment(),
                RentalPeriodConvertet.fromRentalPeriodListEntity(carEntity.getPeriods()),
                null
        );
    }
    public static Car fromEntityGetOrder(CarEntity carEntity){
        if(carEntity == null){
            return null;
        }
        return new Car(
                carEntity.getId(),
                carEntity.getCarModel(),
                carEntity.getCarName(),
                carEntity.getCarYear(),
                carEntity.getCarColor(),
                carEntity.getCarFuel(),
                carEntity.getPriceDay(),
                carEntity.getComment(),
                RentalPeriodConvertet.fromRentalPeriodListEntity(carEntity.getPeriods()),
                null
        );
    }
    public static Car fromEntityRental(CarEntity carEntity){
        if(carEntity == null){
            return null;
        }
        return new Car(
                carEntity.getId(),
                carEntity.getCarModel(),
                carEntity.getCarName(),
                carEntity.getCarYear(),
                carEntity.getCarColor(),
                carEntity.getCarFuel(),
                carEntity.getPriceDay(),
                carEntity.getComment(),
                null,
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
    public static List<Car> fromListEntityCarGetOrder(List<CarEntity> carsEntity){
        List<Car> carList = new ArrayList<>();
        for(CarEntity elem: carsEntity){
            carList.add(CarConverter.fromEntityGetOrder(elem));
        }
        return carList;
    }
    public static List<Car> fromListEntityCarCreateOrder(List<CarEntity> carsEntity){
        List<Car> carList = new ArrayList<>();
        for(CarEntity elem: carsEntity){
            carList.add(CarConverter.fromEntityCreateOrder(elem));
        }
        return carList;
    }
    public static Car fromEntityCreateOrder(CarEntity carEntity){
        if(carEntity == null){
            return null;
        }
        return new Car(       carEntity.getId(),   carEntity.getCarModel(),     carEntity.getCarName(),
                carEntity.getCarYear(),
                carEntity.getCarColor(),
                carEntity.getCarFuel(),
                carEntity.getPriceDay(),
                carEntity.getComment(),
                null,
                null   );
    }
}
