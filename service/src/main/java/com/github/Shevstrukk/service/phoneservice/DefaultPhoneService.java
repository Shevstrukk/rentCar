package com.github.Shevstrukk.service.phoneservice;

import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.entity.Phone;
import com.github.Shevstrukk.dao.phonedao.DefaultPhoneDAO;
import com.github.Shevstrukk.dao.phonedao.PhoneDAO;

import java.util.List;

public class DefaultPhoneService implements PhoneService {
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

    public List<Phone> savePhone(Phone phone, int id){
      return   phoneDAO.savePhone(phone, id);
    }
}
