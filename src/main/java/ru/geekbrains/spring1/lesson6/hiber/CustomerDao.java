package ru.geekbrains.spring1.lesson6.hiber;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CustomerDao {

    List<Product> findAll(Long id);
}
