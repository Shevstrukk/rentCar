package com.github.Shevstrukk.service.phoneservice;

import com.github.Shevstrukk.dao.entity.Phone;
import com.github.Shevstrukk.dao.phonedao.DefaultPhoneDAO;
import com.github.Shevstrukk.dao.phonedao.PhoneDAO;

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
    public void savePhone(Phone phone){
        phoneDAO.insertPhone(phone);
    }
}
