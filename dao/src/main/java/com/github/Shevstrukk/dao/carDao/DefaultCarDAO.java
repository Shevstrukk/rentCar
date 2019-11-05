package com.github.Shevstrukk.dao.carDao;

import com.github.Shevstrukk.dao.entity.Car;
import com.github.Shevstrukk.dao.util.EMUtil;
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
        List<Car> carList;
        Session session = EMUtil.getSession();
        session.beginTransaction();
        String str = "FROM Car  ORDER BY id ASC";
        carList = session.createQuery(str).getResultList();
        session.getTransaction().commit();
        session.close();
        return carList;
    }
    public Car getCar(int id){
        Car car;
        Session session = EMUtil.getSession();
        session.beginTransaction();
        car = session.get(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return car;
    }
}
