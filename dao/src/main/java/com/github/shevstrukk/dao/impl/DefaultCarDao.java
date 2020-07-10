package com.github.shevstrukk.dao.impl;
import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.converter.CarConverter;
import com.github.shevstrukk.dao.converter.OrderConverter;
import com.github.shevstrukk.dao.entity.CarEntity;
import com.github.shevstrukk.model.Car;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.shevstrukk.dao.CarDao;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DefaultCarDao implements CarDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultCarDao.class);

    @Override
    public List<Car> getListCar() {
        List<CarEntity> carEntityList;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String str = "FROM CarEntity  ORDER BY id ASC";
        //String str = "FROM CarEntity e JOIN FETCH e.periods peroid";
        carEntityList = session.createQuery(str).getResultList();
        session.getTransaction().commit();
        session.close();
        return CarConverter.fromListEntityCarGetOrder(carEntityList);
    }
    public Car getCar(Long id){
        CarEntity carEntity=null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        carEntity = session.get(CarEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return CarConverter.fromEntity(carEntity);
    }

    public void deleteCar(Long id){
        CarEntity carEntity;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        carEntity= session.get(CarEntity.class, id);
        session.delete(carEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Car saveCar(Car car) {
        CarEntity carEntity = CarConverter.toEntity(car);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(carEntity);
        session.getTransaction().commit();
        session.close();
        return CarConverter.createCarfromEntity(carEntity);
    }

    @Override
    public Car updateCar(Car car) {
        long id = car.getId();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
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
        session.getTransaction().commit();
        session.close();
        return CarConverter.fromEntity(carEntity);
    }
}
