package com.github.shevstrukk.dao.converter;

import com.github.shevstrukk.dao.entity.UserEntity;
import com.github.shevstrukk.model.User;

public class UserConverter {
    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }
        final UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPhone(user.getPhone());
        userEntity.setAddressEntity(AddressConverter.toEntity(user.getAddress()));
        return userEntity;
    }
    public static User fromEntityAddress(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new User( userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPhone(),
                AuthUserConverter.fromEntityAuth(userEntity.getAuthUserEntity()),
                AddressConverter.fromEntityAddress(userEntity.getAddressEntity()),
                OrderConverter.fromListEntityOrder(userEntity.getOrderEntities()));
    }

    public static User fromEntity(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new User( userEntity.getId(),
        userEntity.getFirstName(),
        userEntity.getLastName(),
        userEntity.getPhone(),
                AuthUserConverter.fromEntityAuth(userEntity.getAuthUserEntity()),
                AddressConverter.fromEntityAddress(userEntity.getAddressEntity()),
                OrderConverter.fromListEntityOrder(userEntity.getOrderEntities()));
    }
    public static User fromEntityCreateOrder(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new User( userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPhone(),
           null,
            null,
             null        );
    }
    public static User fromAuthUserEntity(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new User( userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPhone(),
                null,
                AddressConverter.fromEntity(userEntity.getAddressEntity()),
                OrderConverter.fromListEntityOrder(userEntity.getOrderEntities()));
    }
}
