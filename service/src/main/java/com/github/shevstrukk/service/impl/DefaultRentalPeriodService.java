package com.github.shevstrukk.service.impl;

import com.github.shevstrukk.dao.RentalPeriodDao;
import com.github.shevstrukk.dao.impl.DefaultRentalPeriodDao;
import com.github.shevstrukk.model.RentalPeriod;
import com.github.shevstrukk.service.RentalPeriodService;

public class DefaultRentalPeriodService implements RentalPeriodService {
    private static class SingletonHolder {
        static final RentalPeriodService HOLDER_INSTANCE = new DefaultRentalPeriodService();
    }
    public static RentalPeriodService getInstance() {
        return DefaultRentalPeriodService.SingletonHolder.HOLDER_INSTANCE;
    }

    private RentalPeriodDao rentalDao = DefaultRentalPeriodDao.getInstance();
    @Override
    public RentalPeriod save(RentalPeriod period, Long id) {
        return rentalDao.save( period, id);
    }
}
