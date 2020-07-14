package com.github.Shevstrukk.service.carService;

import com.github.Shevstrukk.dao.carDao.CarsDAO;
import com.github.Shevstrukk.model.Car;

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
    @InjectMocks
    DefaultCarsService service;
    @Mock
    CarsDAO carsDAO;

    @Test
    public void getCar() {
        Car car = new Car(4, "honda",
                1999, "red", 5, "no", null);
        when(carsDAO.getCar(4)).thenReturn(new Car(4, "honda",
                1999, "red", 5, "no", null));
        Car car1 = service.getCar(car.getId());
        assertNotNull(car1);
    }

    @Test
    public void create() {
        Car car = new Car(null, "honda",
                1999, "red", 5, "no", null);
        when(carsDAO.create(car)).thenReturn(new Car(null, "honda",
                1999, "red", 5, "no", null));
        Car car1 = service.create(car);
        assertNotNull(car1);
        assertEquals(car.getPriceDay(),car1.getPriceDay());
        assertEquals(car.getCarYear(),car1.getCarYear());
        assertEquals(car.getCarName(),car1.getCarName());
        assertEquals(car.getCarColor(),car1.getCarColor());
    }

    @Test
    public void update() {
        Car car =new Car(null, "fd", 1998, "red", 12,"no crush", null);
        when(carsDAO.update(car)).thenReturn(new Car(null, "fdfd", 1999, "black", 12,
                "no crush", null));
        Car cardb = service.update(car);
        assertNotNull(cardb);
        assertNotEquals(car, cardb);
    }

    @Test
    public void getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(null, "dsd", 99, "red", 5, "rr", null));
        when(carsDAO.getListCar()).thenReturn(cars);
        List<Car> carList = service.getCars();
        assertNotNull(carList);
        assertEquals(carList.get(0), cars.get(0));
    }

}