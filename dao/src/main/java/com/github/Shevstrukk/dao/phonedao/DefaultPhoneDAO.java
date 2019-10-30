package com.github.Shevstrukk.dao.phonedao;

import com.github.Shevstrukk.dao.entity.Phone;
import com.github.Shevstrukk.dao.util.EMUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultPhoneDAO implements PhoneDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultPhoneDAO.class);
    public DefaultPhoneDAO() {    }

    private static class SingletonHolder {
        static final PhoneDAO HOLDER_INSTANCE = new DefaultPhoneDAO();
    }

    public static PhoneDAO getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
    public void insertPhone(Phone phone){
        Session session = EMUtil.getSession();
        session.beginTransaction();
        session.save(phone);
        session.getTransaction().commit();
        session.close();
    }
}
