package com.github.Shevstrukk.dao.entity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Column(name = "name")
    private  String firstName;

    @Column(name = "surname")
    private  String lastName;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private AuthUserEntity authUserEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private AddressEntity addressEntity;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneEntity> phoneEntities = new ArrayList<>();

    @OneToMany(mappedBy = "person1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orderEntities = new ArrayList<>();

    public PersonEntity() {}

    public PersonEntity(Integer id, String firstName, String lastName, AuthUserEntity authUserEntity, AddressEntity addressEntity, List<PhoneEntity> phoneEntities, List<OrderEntity> orderEntities) {
       this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authUserEntity = authUserEntity;
        this.addressEntity = addressEntity;
        this.phoneEntities = phoneEntities;
        this.orderEntities = orderEntities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


       public AuthUserEntity getAuthUserEntity() {
        return authUserEntity;
    }
    public void setAuthUserEntity(AuthUserEntity authUserEntity) {
        this.authUserEntity = authUserEntity;
    }

    public AddressEntity getAddressEntity() {   return addressEntity;    }
    public void setAddressEntity(AddressEntity addressEntity) {     this.addressEntity = addressEntity;    }

    public List<PhoneEntity> getPhoneEntities() {        return phoneEntities;    }

    public void setPhoneEntities(List<PhoneEntity> phoneEntities) {        this.phoneEntities = phoneEntities;    }

    public void addPhones(PhoneEntity phoneEntity){
        phoneEntity.setPerson(this);
        phoneEntities.add(phoneEntity);
    }

    public List<OrderEntity> getOrderEntities() {        return orderEntities;    }

    public void addOrder(OrderEntity orderEntity){
        orderEntity.setPerson(this);
        orderEntities.add(orderEntity);
    }
    public void removeOrder(OrderEntity orderEntity) {
        getOrderEntities().remove(orderEntity);
        orderEntity.setPerson(null);;
    }

    public void setOrderEntities(List<OrderEntity> orderEntities) {        this.orderEntities = orderEntities;    }
}
