package com.github.Shevstrukk.dao.phonedao;

import com.github.Shevstrukk.dao.converter.PersonConverter;
import com.github.Shevstrukk.dao.converter.PhoneConverter;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.entity.PhoneEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.model.Phone;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DefaultPhoneDAO implements PhoneDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPhoneDAO.class);
    public DefaultPhoneDAO() {    }

    private static class SingletonHolder {
        static final PhoneDAO HOLDER_INSTANCE = new DefaultPhoneDAO();
    }

    public static PhoneDAO getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public Person savePhone(Phone phone, int id){
        PhoneEntity phoneEntity = PhoneConverter.toEntity(phone);
        Session session = EMUtil.getSession();
        session.beginTransaction();
        PersonEntity person = session.get(PersonEntity.class, id);
       // person.getPhoneEntities().clear();
        person.getPhoneEntities().add(phoneEntity);
        phoneEntity.setPerson(person);
        session.saveOrUpdate(person);
        String str = "FROM  PersonEntity e JOIN FETCH e.phoneEntities phon where e.id =: id";
        Query query =  session.createQuery(str);
        query.setParameter("id", id);
        person =(PersonEntity) query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return PersonConverter.fromEntity(person);
    }
    public Person deletePhone(int personId, int id){
        Session session = EMUtil.getSession();
        session.beginTransaction();
        //int personId = person.getId();
        PersonEntity person1 = session.get(PersonEntity.class, personId);
        List<PhoneEntity> phoneEntity = new CopyOnWriteArrayList<>(person1.getPhoneEntities()) ;
        for (PhoneEntity w: phoneEntity){
            if(w.getId().equals(id)){
                phoneEntity.remove(w);
            }
        }
        person1.getPhoneEntities().clear();
        person1.getPhoneEntities().addAll(phoneEntity);
        session.saveOrUpdate(person1);
      //  session.delete(phoneEntity);
        session.getTransaction().commit();
        session.close();
        return PersonConverter.fromEntity(person1);
    }
}
