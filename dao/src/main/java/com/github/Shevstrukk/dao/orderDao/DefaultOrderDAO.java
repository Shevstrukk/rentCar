package com.github.Shevstrukk.dao.orderDao;

import com.github.Shevstrukk.dao.converter.CarConverter;
import com.github.Shevstrukk.dao.converter.OrderConverter;
import com.github.Shevstrukk.dao.converter.PersonConverter;
import com.github.Shevstrukk.dao.entity.CarEntity;
import com.github.Shevstrukk.dao.entity.OrderEntity;
import com.github.Shevstrukk.dao.entity.PersonEntity;
import com.github.Shevstrukk.dao.util.EMUtil;
import com.github.Shevstrukk.model.Car;
import com.github.Shevstrukk.model.Order;
import com.github.Shevstrukk.model.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultOrderDAO implements OrderDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultOrderDAO.class);
    public DefaultOrderDAO() {    }

    private static class SingletonHolder {
        static final OrderDAO HOLDER_INSTANCE = new DefaultOrderDAO();
    }

    public static OrderDAO getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public Order saveOrder(Order order, int id) {
        OrderEntity orderEntity = OrderConverter.toEntity(order);
        // CarEntity carEntity = CarConverter.toEntity(car);
        Session session = EMUtil.getSession();
        session.beginTransaction();
        CarEntity carEntity1  = session.get(CarEntity.class, id);
        orderEntity.getCarEntities().add(carEntity1);
        carEntity1.getOrderEntities().add(orderEntity);
        session.saveOrUpdate(orderEntity);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return OrderConverter.fromEntity(orderEntity);
    }
    public Order saveUpdate(Order order, int id){
        //  OrderEntity orderEntity = OrderConverter.toEntity(order);
        //  CarEntity carEntity = CarConverter.toEntity(car);
        Session session = EMUtil.getSession();
        session.beginTransaction();
        CarEntity carEntity = session.get(CarEntity.class, id);
        //  int orderId = orderEntity.getId();
        OrderEntity orderEntity1 = session.get(OrderEntity.class, order.getId());
        orderEntity1.setPrice(order.getPrice());
        orderEntity1.getCarEntities().add(carEntity);
        carEntity.getOrderEntities().add(orderEntity1);
        session.saveOrUpdate(orderEntity1);
        session.getTransaction().commit();
        session.close();
        return OrderConverter.fromEntity(orderEntity1);
    }
    public Person getOrderList(int id){
        Session session = EMUtil.getSession();
        session.beginTransaction();
        String str = "FROM  PersonEntity e JOIN FETCH e.orderEntities ordered WHERE e.id=:id ";
        Query query = session.createQuery(str);
        query.setParameter("id", id);
        // List<PersonEntity>list = query.list();
        PersonEntity person = (PersonEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return PersonConverter.fromEntityOrder(person);
    }
    public Person deleteOrder(int id, int personId){
        Session session = EMUtil.getSession();
        session.beginTransaction();
        PersonEntity personEntity = session.get(PersonEntity.class, personId);
        for (OrderEntity em: personEntity.getOrderEntities()){
            if(em.getId() == id){
                personEntity.removeOrder(em);
            } break;
        }
        session.saveOrUpdate(personEntity);
        session.getTransaction().commit();
        session.close();
        return PersonConverter.fromEntityOrderList(personEntity);
    }
}
