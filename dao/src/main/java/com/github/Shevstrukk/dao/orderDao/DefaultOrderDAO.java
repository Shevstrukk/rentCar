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
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


public class DefaultOrderDAO implements OrderDAO {
    private static final Logger log = LoggerFactory.getLogger(DefaultOrderDAO.class);
    private final SessionFactory sessionFactory;
    public DefaultOrderDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;    }

    @Override
    public Order saveOrder(Order order) {
        OrderEntity orderEntity = OrderConverter.toEntity(order);
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        session.save(orderEntity);
        return OrderConverter.fromEntity(orderEntity);
    }
    public Order saveUpdate(Order order, int id){
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        CarEntity carEntity = session.get(CarEntity.class, id);
        OrderEntity orderEntity1 = session.get(OrderEntity.class, order.getId());
        orderEntity1.setPrice(order.getPrice());
        orderEntity1.getCarEntities().add(carEntity);
        carEntity.getOrderEntities().add(orderEntity1);
        session.saveOrUpdate(orderEntity1);
        return OrderConverter.fromEntity(orderEntity1);
    }
//    public Person getOrderList(int id){
//        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
//        String str = "FROM  PersonEntity e JOIN FETCH e.orderEntities ordered WHERE e.id=:id ";
//        Query query = session.createQuery(str);
//        query.setParameter("id", id);
//        PersonEntity person = (PersonEntity) query.uniqueResult();
//        return PersonConverter.fromEntityOrder(person);
//    }
    public void deleteOrder(int id){
        Session session = sessionFactory.getCurrentSession();//EMUtil.getSession();
        OrderEntity orderEntity = session.get(OrderEntity.class, id);
        session.remove(orderEntity);
    }
    public Order getOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        OrderEntity orderEntity = session.get(OrderEntity.class, id);
        Order order = OrderConverter.fromEntity(orderEntity);
        return order;
    }
}
