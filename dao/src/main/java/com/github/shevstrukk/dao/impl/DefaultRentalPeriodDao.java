package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.RentalPeriodDao;
import com.github.shevstrukk.dao.converter.RentalPeriodConvertet;
import com.github.shevstrukk.dao.entity.CarEntity;
import com.github.shevstrukk.dao.entity.RentalPeriodEntity;
import com.github.shevstrukk.model.RentalPeriod;
import org.hibernate.Session;

public class DefaultRentalPeriodDao implements RentalPeriodDao {
    public DefaultRentalPeriodDao() {
    }
    private static class SingletonHolder {
        static final DefaultRentalPeriodDao HOLDER_INSTANCE = new DefaultRentalPeriodDao();
    }

    public static DefaultRentalPeriodDao getInstance() {
        return DefaultRentalPeriodDao.SingletonHolder.HOLDER_INSTANCE;
    }
    @Override
    public RentalPeriod save(RentalPeriod period, Long id) {

            RentalPeriodEntity periodEntity = RentalPeriodConvertet.toEntity(period);
            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(periodEntity);
            CarEntity carEntity = session.get(CarEntity.class, id);
            carEntity.addRentalPeriod(periodEntity);
            session.saveOrUpdate(carEntity);

            session.getTransaction().commit();
            session.close();
            return RentalPeriodConvertet.fromEntityRental(periodEntity);

    }
}
