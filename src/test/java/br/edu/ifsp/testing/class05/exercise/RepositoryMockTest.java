package br.edu.ifsp.testing.class05.exercise;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RepositoryMockTest {

    @Mock Repository repository;

    @InjectMocks RepositoryService repositoryService;

    private final Map<Integer, Product> products = new HashMap<>();

    @BeforeEach
    void setUp() {
        products.put(1, new Product("aaa", "Alan", 1.99));
        products.put(2, new Product("bbb", "Matheus", 2.99));
        products.put(3, new Product("ccc", "Ana", 1000.00));
    }

    @Test
    @DisplayName("Update product success")
    void updateProductSuccess() {
        when(repository.findById("aaa")).thenReturn(products.get(1));

        Product product = repositoryService.update("aaa", "Alanzoka", 19.00);

        verify(repository, times(1)).save(product);

        assertEquals("Alanzoka", products.get(1).getName());
    }

    @Test
    @DisplayName("Should throw illegal argument in update")
    void shouldThrowIllegalArgumentInUpdate() {
        when(repository.findById("aaa")).thenReturn(null);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> repositoryService.update("aaa", "algum nome ai", 19.00)
        );
    }

    @Test
    @DisplayName("Save product success")
    void saveProductSuccess() {
        Product product = new Product("ccc", "Ana", 1000.00);

        boolean bool = repositoryService.saveProduct("ccc", "Ana", 1000.00);

        verify(repository, times(1)).save(product);

        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("return error saving null")
    void returnErrorSavingNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> repositoryService.saveProduct(null, "Ana", 1000.00));

        verify(repository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("delete product success")
    void deleteProductSuccess() {

        boolean bool = repositoryService.deleteProduct("aaa");

        verify(repository, times(1)).delete("aaa");

        assertThat(bool).isTrue();
    }


}