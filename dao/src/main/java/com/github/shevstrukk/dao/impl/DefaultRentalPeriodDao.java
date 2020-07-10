package com.github.shevstrukk.dao.impl;

import com.github.shevstrukk.dao.HibernateUtil;
import com.github.shevstrukk.dao.RentalPeriodDao;
import com.github.shevstrukk.dao.converter.RentalPeriodConvertet;
import com.github.shevstrukk.dao.entity.CarEntity;
import com.github.shevstrukk.dao.entity.RentalPeriodEntity;
import com.github.shevstrukk.model.RentalPeriod;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultRentalPeriodDao implements RentalPeriodDao {

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
