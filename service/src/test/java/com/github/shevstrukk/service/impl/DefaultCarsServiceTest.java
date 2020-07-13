package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.CarDao;
import com.github.shevstrukk.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DefaultCarsServiceTest {
    @Mock
    CarDao carDao;
    @InjectMocks
    DefaultCarsService carsService;

    @Test
    public void getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(null, "reno", "scenic", 2010, "black",
                "disel", 5, "ok", null, null));
        when(carDao.getListCar()).thenReturn(cars);
        List<Car> carList = carsService.getCars();
        assertNotNull(carList);
        assertEquals(carList.get(0), cars.get(0));
    }

    @Test
    public void getCar() {
        Car car = new Car(5l, "reno", "scenic", 2010, "black",
                "disel", 5, "ok", null, null);
        when(carDao.getCar(5l)).thenReturn(car);
        Car car1 = carsService.getCar(car.getId());
        assertNotNull(car1);
    }


    @Test
    public void saveCar() {
        Car car = new Car(5l, "reno", "scenic", 2010, "black",
                "disel", 5, "ok", null, null);
        when(carDao.saveCar(car)).thenReturn(new Car(5l, "reno", "scenic", 2010, "black",
                "disel", 5, "ok", null, null));
        Car car1 = carsService.saveCar(car);
        assertNotNull(car1);
        assertEquals(car.getPriceDay(),car1.getPriceDay());
        assertEquals(car.getCarYear(),car1.getCarYear());
        assertEquals(car.getCarName(),car1.getCarName());
        assertEquals(car.getCarColor(),car1.getCarColor());
    }
}