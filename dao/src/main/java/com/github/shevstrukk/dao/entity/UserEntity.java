package com.github.shevstrukk.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name ="phone")
    private String phone;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private AuthUserEntity authUserEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private AddressEntity addressEntity;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orderEntities;

    public UserEntity() {
    }

    public UserEntity(Long id,String firstName, String lastName, String phone,
                      AuthUserEntity authUserEntity, AddressEntity addressEntity,
                      List<OrderEntity> orderEntities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.authUserEntity = authUserEntity;
        this.addressEntity = addressEntity;
        this.orderEntities = orderEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AuthUserEntity getAuthUserEntity() {
        return authUserEntity;
    }

    public void setAuthUserEntity(AuthUserEntity authUserEntity) {
        this.authUserEntity = authUserEntity;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public void addOrder(OrderEntity orderEntity){
        orderEntity.setUserEntity(this);
        orderEntities.add(orderEntity);
    }
    public void removeOrder(OrderEntity orderEntity) {
        orderEntity.setUserEntity(null);
        orderEntities.remove(orderEntity);
    }

    public List<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(List<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }
}

