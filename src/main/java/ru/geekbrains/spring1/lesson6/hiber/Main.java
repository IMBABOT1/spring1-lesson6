package ru.geekbrains.spring1.lesson6.hiber;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            CustomerDao customerDao = new CustomerDaoImpl(sessionFactoryUtils);
            List<Product> products = customerDao.findAll(1l);
          //  System.out.println(products);


            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            List<Customer> customers = productDao.findAll(1l);
            System.out.println(customers);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
