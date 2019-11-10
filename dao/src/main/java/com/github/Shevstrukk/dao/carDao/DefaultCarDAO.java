package com.github.Shevstrukk.dao.carDao;

import com.github.Shevstrukk.dao.converter.CarConverter;

import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.Car;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DefaultCarDAO implements CarsDAO{

    private static final Logger log = LoggerFactory.getLogger(DefaultCarDAO.class);

    public DefaultCarDAO() {
    }
    private static class SingletonHolder {
        static final CarsDAO HOLDER_INSTANCE = new DefaultCarDAO();
    }

    public static CarsDAO getInstance() {
        return DefaultCarDAO.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public List<Car> getListCar() {
        List<CarEntity> carEntityList;
        Session session = EMUtil.getSession();
        session.beginTransaction();
        String str = "FROM CarEntity  ORDER BY id ASC";
        carEntityList = session.createQuery(str).getResultList();
        session.getTransaction().commit();
        session.close();
        return CarConverter.fromListEntityCar(carEntityList);
    }
    public Car getCar(int id){
        CarEntity carEntity;
        Session session = EMUtil.getSession();
        session.beginTransaction();
        carEntity = session.get(CarEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return CarConverter.fromEntity(carEntity);
    }
}
