package ru.geekbrains.spring1.lesson6.hiber;

import java.util.List;

public interface ProductDao {

    List<Customer> findAll(Long id);
}
