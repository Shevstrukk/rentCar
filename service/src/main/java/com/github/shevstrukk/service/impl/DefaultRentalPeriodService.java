package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.RentalPeriodDao;
import com.github.shevstrukk.model.RentalPeriod;
import com.github.shevstrukk.service.RentalPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultRentalPeriodService implements RentalPeriodService {

    @Autowired
    private RentalPeriodDao rentalDao;
    @Override
    public RentalPeriod save(RentalPeriod period, Long id) {
        return rentalDao.save( period, id);
    }
}
