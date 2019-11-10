package com.github.Shevstrukk.dao.converter;

import com.github.Shevstrukk.dao.entity.PhoneEntity;
import com.github.Shevstrukk.model.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneConverter {
    public static Phone fromEntity(PhoneEntity phoneEntity){
        if(phoneEntity == null){
            return  null;
        }
        return  new Phone(
                phoneEntity.getId(),
                phoneEntity.getLine(),
                PersonConverter.fromEntity(phoneEntity.getPerson())
        );
    }
    public static PhoneEntity toEntity(Phone phone){
        if(phone == null){
            return  null;
        }
        final PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setId(phone.getId());
        phoneEntity.setLine(phone.getLine());
       // phoneEntity.setPerson(PersonConverter.toEntity(phone.getPerson()));
        phoneEntity.setPerson(null);
        return phoneEntity;
    }
    public static List<PhoneEntity> toListEntityPhone(List<Phone> phones){
        List<PhoneEntity> phoneEntityList = new ArrayList<>();
        for(Phone elem: phones){
            phoneEntityList.add(PhoneConverter.toEntity(elem));
        }
        return phoneEntityList;
    }
    public static List<Phone> fromListEntityPhone(List<PhoneEntity> phones){
        List<Phone> phoneList = new ArrayList<>();
        for(PhoneEntity elem: phones){
            phoneList.add(PhoneConverter.fromEntity(elem));
        }
        return phoneList;
    }
}
