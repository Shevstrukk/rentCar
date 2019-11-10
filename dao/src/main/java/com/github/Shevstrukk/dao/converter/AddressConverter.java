package com.github.Shevstrukk.dao.converter;

import com.github.Shevstrukk.dao.entity.AddressEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.model.Address;
import com.github.Shevstrukk.model.Person;

public class AddressConverter {
    public static AddressEntity toEntity(Address address){
        if(address == null){
            return  null;
        }
        final AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(address.getId());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setHome(address.getHome());
        addressEntity.setStreet(address.getStreet());
        addressEntity.setNumber(address.getNumber());
       // addressEntity.setPerson(PersonConverter.toEntity(address.getPerson()));
        addressEntity.setPerson(null);
        return addressEntity;
    }
   public static Address fromEntity(AddressEntity addressEntity){
        if(addressEntity == null){
            return  null;
        }
        return new Address(
                addressEntity.getId(),
                addressEntity.getState(),
                addressEntity.getCity(),
                addressEntity.getStreet(),
                addressEntity.getHome(),
                addressEntity.getNumber(),
           // PersonConverter.fromEntity(addressEntity.getPerson())
                null
        );
   }

}
