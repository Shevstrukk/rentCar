package com.github.Shevstrukk.dao.carDao;

import com.github.Shevstrukk.dao.converter.CarConverter;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

public class DefaultCarDAO implements CarsDAO{

    private static final Logger log = LoggerFactory.getLogger(DefaultCarDAO.class);
    private final SessionFactory sessionFactory;

    public DefaultCarDAO(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Car> getListCar() {
        List<CarEntity> carEntityList;
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        String str = "FROM CarEntity  ORDER BY id ASC";
        carEntityList = session.createQuery(str).getResultList();
        return CarConverter.fromListEntityCar(carEntityList);
    }
    public Car getCar(int id){
        CarEntity carEntity;
        Session session = sessionFactory.getCurrentSession();// EMUtil.getSession();
        carEntity = session.get(CarEntity.class, id);
        return CarConverter.fromEntity(carEntity);
    }
    public Car create(Car car){
        CarEntity carEntity = CarConverter.toEntity(car);
        Session session =  sessionFactory.getCurrentSession();
        session.save(carEntity);
        return CarConverter.fromEntity(carEntity);
    }
    public Car update(Car car){
        Session session =  sessionFactory.getCurrentSession();
        CarEntity carEntity = session.get(CarEntity.class, car.getId());
        carEntity.setCarColor(car.getCarColor());
        carEntity.setCarName(car.getCarName());
        carEntity.setCarYear(car.getCarYear());
        carEntity.setComment(car.getComment());
        carEntity.setPriceDay(car.getPriceDay());
        session.update(carEntity);
        return CarConverter.fromEntity(carEntity);
    }
    public void delete(int id){
        Session session =  sessionFactory.getCurrentSession();
        CarEntity carEntity = session.get(CarEntity.class, id);
        session.delete(carEntity);
    }
}
