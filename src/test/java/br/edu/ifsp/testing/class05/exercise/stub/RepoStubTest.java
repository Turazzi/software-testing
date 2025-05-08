package br.edu.ifsp.testing.class05.exercise.stub;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

import br.edu.ifsp.testing.class05.exercise.Product;
import br.edu.ifsp.testing.class05.exercise.RepositoryService;
import org.junit.jupiter.api.*;

import java.util.List;


public class RepoStubTest {

    RepoStub repoStub;
    RepositoryService repositoryService;

    @BeforeEach
    void setUp() {
        repoStub = new RepoStub();
        repositoryService = new RepositoryService(repoStub);
    }

    @Nested
    @DisplayName("Testing valid cases")
    class ValidCases {

        @Test
        @DisplayName("Testing update method")
        void testingUpdateMethod () {
            repositoryService.updateProduct(new Product("bbb", "Fefeu", 5.0));
            assertThat(repositoryService.getProduct("bbb").get().getName()).isEqualTo("Fefeu");
        }

        @Test
        @DisplayName("Testing save method")
        void testingSaveMethod () {
            repositoryService.saveProduct(new Product("ddd", "Candido", 10.0));
            assertThat(repositoryService.getProduct("ddd").get().getName()).isEqualTo("Candido");
            assertThat(repositoryService.getProduct("ddd").get().getPrice()).isEqualTo(10.0);
        }

        @Test
        @DisplayName("Testing remove method")
        void testingRemoveMethod() {
            repositoryService.deleteProduct("bbb");
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> repositoryService.getProduct("bbb")
            );
        }

        @Test
        @DisplayName("Testing find all")
        void testingFindAll() {
            assertThat(repositoryService.getAllProducts().get()).isNotEmpty();
        }

        @Test
        @DisplayName("Testing find by id")
        void testingFindById() {
            assertThat(repositoryService.getProduct("bbb").get().getName()).isEqualTo("Chocolate");
        }
    }

    @Nested
    @DisplayName("Testing invalid cases")
    class InvalidCases {

        @Test
        @DisplayName("Testing update message error")
        void testingUpdateMessageError() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> repositoryService.updateProduct(new Product("eee", "Fefeu", 5.0))
            ).withMessage("This product does not exist");
        }

        @Test
        @DisplayName("Testing delete message error")
        void testingDeleteMessageError() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> repositoryService.deleteProduct("eee")
            ).withMessage("This product does not exist");
        }

        @Test
        @DisplayName("Testing save message error")
        void testingSaveMessageError() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> repositoryService.saveProduct(new Product("aaa", "Fefeu", 5.0))
            ).withMessage("This product already exists");
        }

    }

}
