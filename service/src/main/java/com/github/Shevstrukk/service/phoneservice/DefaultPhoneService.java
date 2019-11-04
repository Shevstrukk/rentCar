package com.github.Shevstrukk.service.phoneservice;

import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.entity.Phone;
import com.github.Shevstrukk.dao.phonedao.DefaultPhoneDAO;
import com.github.Shevstrukk.dao.phonedao.PhoneDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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

    public Person savePhone(Phone phone, int id){
      return   phoneDAO.savePhone(phone, id);
    }

    public Person deletePhone(int personId, int id){
      return   phoneDAO.deletePhone( personId,  id);
    }
}
