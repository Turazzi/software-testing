package br.edu.ifsp.testing.class05.exercise;

import java.util.List;
import java.util.Optional;

public class RepositoryService {

    private final Repository repository;

    public RepositoryService(Repository repository) {
        this.repository = repository;
    }

    public Product update(String uuid, String name, double price) {

        if(price <= 0) throw new IllegalArgumentException("Price must be greater than 0");
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if(uuid == null || uuid.isEmpty()) throw new IllegalArgumentException("UUID cannot be null or empty");

        Product product = repository.findById(uuid);

        if(product == null) throw new IllegalArgumentException("Product not found");

        product.updateProduct(name, price);

        repository.save(product);

        return product;
    }

    public boolean saveProduct(String uuid, String name, double price) {

        if(price <= 0) throw new IllegalArgumentException("Price must be greater than 0");
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if(uuid == null || uuid.isEmpty()) throw new IllegalArgumentException("UUID cannot be null or empty");

        Product product = new Product(uuid, name, price);

        repository.save(product);

        return true;
    }

    public boolean deleteProduct(String uuid) {

        if(uuid == null || uuid.isEmpty()) throw new IllegalArgumentException("UUID cannot be null or empty");

        repository.delete(uuid);

        return true;

    }


}
