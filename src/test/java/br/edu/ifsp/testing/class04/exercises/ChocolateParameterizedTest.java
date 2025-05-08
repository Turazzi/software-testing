package br.edu.ifsp.testing.class04.exercises;

import br.edu.ifsp.testing.class03.exercises.Chocolate;
import org.junit.jupiter.api.BeforeEach;

public class ChocolateParameterizedTest {

    Chocolate chocolate;

    @BeforeEach
    void setUp() {
        chocolate = new Chocolate();
    }




}
