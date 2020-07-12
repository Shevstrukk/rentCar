package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.RentalPeriodDao;
import com.github.shevstrukk.model.RentalPeriod;
import com.github.shevstrukk.service.RentalPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DefaultRentalPeriodService implements RentalPeriodService {


    private final  RentalPeriodDao rentalDao;

    public DefaultRentalPeriodService(RentalPeriodDao rentalDao) {
        this.rentalDao = rentalDao;
    }

    @Override
    public RentalPeriod save(RentalPeriod period, Long id) {
        return rentalDao.save( period, id);
    }
}
