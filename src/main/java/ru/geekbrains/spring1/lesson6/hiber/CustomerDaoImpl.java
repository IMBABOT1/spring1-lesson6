package ru.geekbrains.spring1.lesson6.hiber;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    private SessionFactoryUtils sessionFactoryUtils;

    public CustomerDaoImpl(SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @PostConstruct
    public void init(){
        sessionFactoryUtils.init();
    }



    @Override
    public List<Product> findAll(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            List<Product> products = customer.getProducts();
            session.getTransaction().commit();
            return products;
        }
    }
}
