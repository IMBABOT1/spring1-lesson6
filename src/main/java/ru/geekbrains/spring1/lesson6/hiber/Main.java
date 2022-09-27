package ru.geekbrains.spring1.lesson6.hiber;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            CustomerDao customerDao = new CustomerDaoImpl(sessionFactoryUtils);
            List<Product> products = customerDao.findProductsByCustomerId(1l);
            System.out.println(products);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
