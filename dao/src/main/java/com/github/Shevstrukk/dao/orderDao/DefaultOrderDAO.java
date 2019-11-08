package com.github.Shevstrukk.dao.orderDao;

import com.github.Shevstrukk.dao.entity.Car;
import com.github.Shevstrukk.dao.entity.Order;
import com.github.Shevstrukk.dao.entity.Person;
import com.github.Shevstrukk.dao.util.EMUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
    public Order saveOrder(Order order, Car car) {
        Session session = EMUtil.getSession();
        session.beginTransaction();
        order.addCar(car);
        car.getOrders().add(order);
        session.saveOrUpdate(order);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return order;
    }
    public Order saveOrUpdate(Order order, Car car){
        Session session = EMUtil.getSession();
        session.beginTransaction();
        int orderId = order.getId();
         Order order1 = session.get(Order.class, orderId);
         order1.setPrice(order.getPrice());
        order1.getCars().add(car);
        car.getOrders().add(order1);
        session.saveOrUpdate(order);
        session.getTransaction().commit();
        session.close();
        return order1;
    }
    public Person getOrderList(int id){
        Session session = EMUtil.getSession();
        session.beginTransaction();
        String str = "FROM  Person e JOIN FETCH e.orders ordered WHERE e.id=:id ";
        Query query = session.createQuery(str);
        query.setParameter("id", id);
       // List<Person>list = query.list();
        Person person = (Person) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return person;
    }
}
