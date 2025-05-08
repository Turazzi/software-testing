//package br.edu.ifsp.testing.class05.exercise.stub;
//
//import br.edu.ifsp.testing.class05.exercise.Product;
//import br.edu.ifsp.testing.class05.exercise.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class RepoStub implements Repository<String, Product>{
//
//    List<Product> products ;
//
//    public RepoStub() {
//        this.products = new ArrayList<>(List.of(
//                new Product("aaa", "Pasta de Dente", 5.50),
//                new Product("bbb", "Chocolate", 10.99),
//                new Product("ccc", "Leite", 6.5)
//        ));
//    }
//
//    @Override
//    public Optional<List<Product>> findAll() {
//        return Optional.of(products);
//    }
//
//    @Override
//    public Optional<Product> findById(String id) {
//        return products.stream()
//                .filter(p -> p.getUuid().equals(id))
//                .findFirst();
//    }
//
//    @Override
//    public void save(Product entity) {
//        products.add(entity);
//    }
//
//    @Override
//    public void update(Product entity) {
//        Product old = products.stream()
//                .filter(p -> p.getUuid().equals(entity.getUuid()))
//                .findFirst().get();
//        products.remove(old);
//        products.add(entity);
//
//    }
//
//    @Override
//    public void delete(String id) {
//        products.removeIf(p -> p.getUuid().equals(id));
//    }
//}
