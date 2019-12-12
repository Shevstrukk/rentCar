package com.github.Shevstrukk.dao.carDao;

import com.github.Shevstrukk.dao.config.DaoConfig;
import com.github.Shevstrukk.model.Car;


import static org.junit.Assert.*;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class DefaultCarDAOTest {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
   private CarsDAO carDao;

    @Test
    public void getListCar() {
        Car car = new Car(null, "honda",
                2019, "black", 6, "no crash", null);
        Car car1 = new Car(null, "honda",
                2019, "black", 6, "no crash", null);
        Car carNew = carDao.create(car);
        Car carNew1 = carDao.create(car1);
        List<Car> carList = carDao.getListCar();
        assertNotNull(carList);
    }

    @Test
    public void getCar() {
        Car car = new Car(null, "honda",
                2019, "black", 6, "no crash", null);
        Car carNew = carDao.create(car);
        int id = carNew.getId();
        Car fromDB = carDao.getCar(id);
        assertNotNull(carNew);
        assertNotNull(fromDB);
        assertEquals(car.getCarName(),fromDB.getCarName() );
        assertEquals(car.getCarYear(),fromDB.getCarYear() );
        assertEquals(car.getPriceDay(),fromDB.getPriceDay());
        assertEquals(carNew.getId(),fromDB.getId());

    }

    @Test
    public void create() {
        Car car = new Car(null, "honda",
                2019, "black", 6, "no crash", null);
        Car carNew = carDao.create(car);
        assertNotNull(carNew);
        assertEquals(car.getPriceDay(),carNew.getPriceDay());
        assertEquals(car.getCarYear(),carNew.getCarYear());
        assertEquals(car.getCarName(),carNew.getCarName());
        assertEquals(car.getComment(),carNew.getComment());
    }

    @Test
    public void update() {
        Car car = new Car(null, "honda",
                2019, "black", 6, "no crash", null);
        Car carNew = carDao.create(car);
        carNew.setPriceDay(10);
        Car carUpdate = carDao.update(carNew);
        assertNotNull(carNew);
        assertNotNull(carUpdate);
        assertEquals(carUpdate.getPriceDay(), 10);
    }

    @Test
    public void delete() {
        Car car = new Car(null, "honda",
                2019, "black", 6, "no crash", null);
        Car carNew = carDao.create(car);
        int id= carNew.getId();
        carDao.delete(id);
        Car carDelete =carDao.getCar(id);
        assertNotNull(carNew);
        assertNull(carDelete);
    }
}