package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.RentalPeriodDao;
import com.github.shevstrukk.model.Car;
import com.github.shevstrukk.model.RentalPeriod;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;


import java.time.LocalDateTime;


@ExtendWith(MockitoExtension.class)
public class DefaultRentalPeriodServiceTest {
    @Mock
    RentalPeriodDao rentalPeriodDao;
    @InjectMocks
    DefaultRentalPeriodService periodService;

    @Test
    public void save() {
       Car car =  new Car(5l, "reno", "scenic", 2010, "black",
                "disel", 5, "ok", null, null);
        RentalPeriod rentalPeriod = new RentalPeriod(null, LocalDateTime.now(), LocalDateTime.now(), car );
        when(rentalPeriodDao.save(rentalPeriod, car.getId())).thenReturn(rentalPeriod);
        RentalPeriod rentalPeriod1 = periodService.save(rentalPeriod, car.getId());
        assertNotNull(rentalPeriod1);
        assertEquals(rentalPeriod.getStart(),rentalPeriod1.getStart());
        assertEquals(rentalPeriod.getEnd(), rentalPeriod1.getEnd());
    }
}