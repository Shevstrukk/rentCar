package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.RentalPeriodDao;
import com.github.shevstrukk.dao.converter.RentalPeriodConvertet;
import com.github.shevstrukk.dao.entity.CarEntity;
import com.github.shevstrukk.dao.entity.RentalPeriodEntity;
import com.github.shevstrukk.model.RentalPeriod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class DefaultRentalPeriodDao implements RentalPeriodDao {
    private final SessionFactory factory;

    public DefaultRentalPeriodDao(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public RentalPeriod save(RentalPeriod period, Long id) {

        RentalPeriodEntity periodEntity = RentalPeriodConvertet.toEntity(period);
        final Session session = factory.getCurrentSession();
        session.save(periodEntity);
        CarEntity carEntity = session.get(CarEntity.class, id);
        carEntity.addRentalPeriod(periodEntity);
        session.saveOrUpdate(carEntity);
        return RentalPeriodConvertet.fromEntityRental(periodEntity);

    }
}