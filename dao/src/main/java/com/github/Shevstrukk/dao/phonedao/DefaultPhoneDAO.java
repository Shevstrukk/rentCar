package com.github.Shevstrukk.dao.phonedao;

import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.entity.Phone;
import com.github.Shevstrukk.dao.util.EMUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import java.util.List;

public class DefaultPhoneDAO implements PhoneDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPhoneDAO.class);
    public DefaultPhoneDAO() {    }

    private static class SingletonHolder {
        static final PhoneDAO HOLDER_INSTANCE = new DefaultPhoneDAO();
    }

    public static PhoneDAO getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public List<Phone> savePhone(Phone phone, int id){
        List<Phone> phones;
        Session session = EMUtil.getSession();
        session.beginTransaction();
        Person person = session.get(Person.class, id);
       // person.getPhones().clear();
        person.getPhones().add(phone);
        phone.setPerson(person);
        session.saveOrUpdate(person);
        phones = person.getPhones();
      //  phone.setPerson(person);
        //session.save(phone);
        session.getTransaction().commit();
        session.close();
        return phones;
    }
}
