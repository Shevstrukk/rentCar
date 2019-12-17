package com.github.Shevstrukk.dao.phonedao;

import com.github.Shevstrukk.dao.converter.PersonConverter;
import com.github.Shevstrukk.dao.converter.PhoneConverter;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.entity.PhoneEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DefaultPhoneDAO implements PhoneDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPhoneDAO.class);
    private final SessionFactory sessionFactory;
    public DefaultPhoneDAO(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory;    }


    public Person savePhone(Phone phone, int id){
        PhoneEntity phoneEntity = PhoneConverter.toEntity(phone);
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        PersonEntity person = session.get(PersonEntity.class, id);
        person.getPhoneEntities().add(phoneEntity);
        phoneEntity.setPerson(person);
        session.saveOrUpdate(person);
        String str = "FROM  PersonEntity e JOIN FETCH e.phoneEntities phon where e.id =: id";
        Query query =  session.createQuery(str);
        query.setParameter("id", id);
        person =(PersonEntity) query.getSingleResult();
        return PersonConverter.fromEntityCreatePhone(person);
    }

    public Person deletePhone( int id){
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        PhoneEntity phone = session.get(PhoneEntity.class,id);
        List<PhoneEntity> phoneEntity = new CopyOnWriteArrayList<>(phone.getPerson().getPhoneEntities()) ;
        for (PhoneEntity w: phoneEntity){
            if(w.getId().equals(id)){
                phoneEntity.remove(w);
            }
        }
        PersonEntity person1 = session.get(PersonEntity.class, phone.getPerson().getId());
        person1.getPhoneEntities().clear();
        person1.getPhoneEntities().addAll(phoneEntity);
        session.saveOrUpdate(person1);
        return PersonConverter.fromEntityCreatePhone(person1);
    }
}
