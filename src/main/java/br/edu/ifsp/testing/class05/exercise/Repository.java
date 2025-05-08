package br.edu.ifsp.testing.class05.exercise;

import java.util.List;
import java.util.Optional;

public interface Repository {

    List<Product> findAll();
    Product findById(String id);
    void save (Product entity);
    void update (Product entity);
    void delete (String id);

}
