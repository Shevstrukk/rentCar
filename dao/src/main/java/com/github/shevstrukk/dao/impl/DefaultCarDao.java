package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.converter.CarConverter;
import com.github.shevstrukk.dao.converter.OrderConverter;
import com.github.shevstrukk.dao.entity.CarEntity;
import com.github.shevstrukk.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.shevstrukk.dao.CarDao;


import java.util.List;

public class DefaultCarDao implements CarDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultCarDao.class);
    private final SessionFactory factory;

    public DefaultCarDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Car> getListCar() {
        List<CarEntity> carEntityList;
        final Session session = factory.getCurrentSession();
        String str = "FROM CarEntity  ORDER BY id ASC";
        //String str = "FROM CarEntity e JOIN FETCH e.periods peroid";
        carEntityList = session.createQuery(str).getResultList();
        return CarConverter.fromListEntityCarGetOrder(carEntityList);
    }
    public Car getCar(Long id){
        CarEntity carEntity=null;
        final Session session = factory.getCurrentSession();
        carEntity = session.get(CarEntity.class, id);
        return CarConverter.fromEntity(carEntity);
    }

    public void deleteCar(Long id){
        CarEntity carEntity;
        final Session session = factory.getCurrentSession();
        carEntity= session.get(CarEntity.class, id);
        session.delete(carEntity);
    }

    @Override
    public Car saveCar(Car car) {
        CarEntity carEntity = CarConverter.toEntity(car);
        final Session session = factory.getCurrentSession();
        session.saveOrUpdate(carEntity);
        return CarConverter.createCarfromEntity(carEntity);
    }

    @Override
    public Car updateCar(Car car) {
        long id = car.getId();
        final Session session = factory.getCurrentSession();
        CarEntity carEntity = session.get(CarEntity.class, id);
        carEntity.setCarModel(car.getCarModel());
        carEntity.setCarName(car.getCarName());
        carEntity.setCarYear(car.getCarYear());
        carEntity.setCarColor(car.getCarColor());
        carEntity.setCarFuel(car.getCarFuel());
        carEntity.setPriceDay(car.getPriceDay());
        carEntity.setComment(car.getComment());
        carEntity.setOrderEntityList(OrderConverter.toListOrderEntity(car.getOrderList()));
        session.update(carEntity);
        return CarConverter.fromEntity(carEntity);
    }
}