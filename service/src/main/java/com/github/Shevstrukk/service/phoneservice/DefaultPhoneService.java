package com.github.Shevstrukk.service.phoneservice;

import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.entity.PhoneEntity;
import com.github.Shevstrukk.dao.phonedao.DefaultPhoneDAO;
import com.github.Shevstrukk.dao.phonedao.PhoneDAO;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.model.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultPhoneService implements PhoneService {
    private static final Logger log = LoggerFactory.getLogger(DefaultPhoneService.class);
    private PhoneDAO phoneDAO = DefaultPhoneDAO.getInstance();

    public DefaultPhoneService() {}

    public DefaultPhoneService(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    private static class SingletonHolder {
        static final PhoneService HOLDER_INSTANCE = new DefaultPhoneService();
    }
    public static PhoneService getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public Person savePhone(Phone phoneEntity, int id){
        return   phoneDAO.savePhone(phoneEntity, id);
    }

    public Person deletePhone( int id){
        return   phoneDAO.deletePhone(id);
    }
}
