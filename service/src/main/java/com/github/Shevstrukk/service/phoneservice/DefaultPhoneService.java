package com.github.Shevstrukk.service.phoneservice;

import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.entity.PhoneEntity;
import com.github.Shevstrukk.dao.phonedao.DefaultPhoneDAO;
import com.github.Shevstrukk.dao.phonedao.PhoneDAO;
import com.github.Shevstrukk.model.Person;
import com.github.Shevstrukk.model.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPhoneService implements PhoneService {
    private static final Logger log = LoggerFactory.getLogger(DefaultPhoneService.class);
    @Autowired
    DefaultPhoneDAO defaultPhoneDAO;

    public Person savePhone(Phone phoneEntity, int id){
        return  defaultPhoneDAO.savePhone(phoneEntity, id);
    }

    public Person deletePhone( int id){
        return   defaultPhoneDAO.deletePhone(id);
    }
}
