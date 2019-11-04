package com.github.Shevstrukk.dao.phonedao;

import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.entity.Phone;
import com.github.Shevstrukk.dao.util.EMUtil;
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
        List<Phone> phones;
        Session session = EMUtil.getSession();
        session.beginTransaction();
        Person person = session.get(Person.class, id);
       // person.getPhones().clear();
        person.getPhones().add(phone);
        phone.setPerson(person);
        session.saveOrUpdate(person);
        String str = "FROM  Person e JOIN FETCH e.phones phon where e.id =: id";
        Query query =  session.createQuery(str);
        query.setParameter("id", id);
        person =(Person) query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return person;
    }
    public Person deletePhone(int personId, int id){
        Session session = EMUtil.getSession();
        session.beginTransaction();
        //int personId = person.getId();
        Person person1 = session.get(Person.class, personId);
        List<Phone> phone = new CopyOnWriteArrayList<>(person1.getPhones()) ;
        for (Phone w: phone){
            if(w.getId().equals(id)){
                phone.remove(w);
            }
        }
        person1.getPhones().clear();
        person1.getPhones().addAll(phone);
        session.saveOrUpdate(person1);
      //  session.delete(phone);
        session.getTransaction().commit();
        session.close();
        return person1;
    }
}
