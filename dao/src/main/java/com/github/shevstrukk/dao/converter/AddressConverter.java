package com.github.shevstrukk.dao.converter;

import com.github.shevstrukk.dao.entity.AddressEntity;
import com.github.shevstrukk.model.Address;

public class AddressConverter {
    public static AddressEntity toEntity(Address address) {
        if (address == null) {
            return null;
        }
        final AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(address.getId());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setCity(address.getCity());
        addressEntity.setStreet(address.getStreet());
        addressEntity.setHome(address.getHome());
        addressEntity.setNumber(address.getNumber());
        return addressEntity;
    }
    public static Address fromEntity(AddressEntity entity){
        if(entity==null){
            return null;
        }
        return new Address(entity.getId(),
                entity.getCountry(),
                entity.getCity(),
                entity.getStreet(),
                entity.getHome(),
                entity.getNumber(),
               null
                );
    }
    public static Address fromEntityAddress(AddressEntity entity){
        if(entity==null){
            return null;
        }
        return new Address(entity.getId(),
                entity.getCountry(),
                entity.getCity(),
                entity.getStreet(),
                entity.getHome(),
                entity.getNumber(),
               null
        );
    }
}
