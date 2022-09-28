package ru.geekbrains.spring1.lesson6.hiber;

import org.hibernate.Session;

import javax.annotation.PostConstruct;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @PostConstruct
    public void init(){
        sessionFactoryUtils.init();
    }


    @Override
    public List<Customer> findAll(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            List<Customer> products = product.getCustomers();
            session.getTransaction().commit();
            return products;
        }
    }
}
