package com.github.Shevstrukk.dao.converter;

import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonConverter {
    public static PersonEntity toEntity(Person person){
        if(person == null){
            return  null;
        }
        final PersonEntity personEntity = new PersonEntity();
        if(person.getId() !=null){
            personEntity.setId(person.getId());
        }
        personEntity.setAddressEntity(AddressConverter.toEntity(person.getAddress()));
        personEntity.setAuthUserEntity(AuthUserConverter.toEntity(person.getAuthUser()));
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        if(person.getOrders() != null){
            personEntity.setOrderEntities(OrderConverter.toListOrderEntity(person.getOrders()));
        }
        if(person.getPhones() !=null){
            personEntity.setPhoneEntities(PhoneConverter.toListEntityPhone(person.getPhones()));
        }
        return personEntity;
    }
    public static Person fromEntity(PersonEntity personEntity){
        if(personEntity==null){
            return null;
        }
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                AuthUserConverter.fromEntity(personEntity.getAuthUserEntity()),
                AddressConverter.fromEntity(personEntity.getAddressEntity()),
                PhoneConverter.fromListEntityPhone(personEntity.getPhoneEntities()),
                OrderConverter.fromListOrderEntityNoCar(personEntity.getOrderEntities()));
    }
    public static Person fromEntityOrderList(PersonEntity personEntity){
        if(personEntity==null){
            return null;
        }
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                null,//AuthUserConverter.fromEntity(personEntity.getAuthUserEntity()),
                null,// AddressConverter.fromEntity(personEntity.getAddressEntity()),
                null,// PhoneConverter.fromListEntityPhone(personEntity.getPhoneEntities()),
                OrderConverter.fromListOrderEntity(personEntity.getOrderEntities()));
    }
    public static Person fromEntityList(PersonEntity personEntity){
        if(personEntity==null){
            return null;
        }
        return new Person(///////////////////
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                null,//AuthUserConverter.fromEntity(personEntity.getAuthUserEntity()),
                AddressConverter.fromEntity(personEntity.getAddressEntity()),
                null,// PhoneConverter.fromListEntityPhone(personEntity.getPhoneEntities()),
                null);// OrderConverter.fromListOrderEntityNoCar(personEntity.getOrderEntities()));
    }

    public static Person fromEntityCreatePhone(PersonEntity personEntity){
        if(personEntity==null){
            return null;
        }
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                AuthUserConverter.fromEntity(personEntity.getAuthUserEntity()),
                AddressConverter.fromEntity(personEntity.getAddressEntity()),
                PhoneConverter.fromListEntityPhone(personEntity.getPhoneEntities()),
                // OrderConverter.fromListOrderEntity(personEntity.getOrderEntities()));
                null);
    }

    public static List<Person> fromListPersonEntity(List<PersonEntity> personEntityList){
        List<Person> personList = new ArrayList<>();
        for(PersonEntity elem: personEntityList){
            personList.add(PersonConverter.fromEntity(elem));
        }
        return personList;
    }
    public static Person fromEntityOrder(PersonEntity personEntity){
        if(personEntity==null){
            return null;
        }
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                AuthUserConverter.fromEntity(personEntity.getAuthUserEntity()),
                AddressConverter.fromEntity(personEntity.getAddressEntity()),
                null,
                //   PhoneConverter.fromListEntityPhoneOrder(personEntity.getPhoneEntities()),
                OrderConverter.fromListOrderEntity(personEntity.getOrderEntities()));
    }
    public static Person fromEntityAuth(PersonEntity personEntity){
        if(personEntity==null){
            return null;
        }
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                null ,//AuthUserConverter.fromEntity(personEntity.getAuthUserEntity()),
                AddressConverter.fromEntity(personEntity.getAddressEntity()),
                null,
                //   PhoneConverter.fromListEntityPhoneOrder(personEntity.getPhoneEntities()),
                null); //OrderConverter.fromListOrderEntity(personEntity.getOrderEntities()));
    }


}
