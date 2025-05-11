package br.edu.ifsp.testing.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class TriangleUtilsTest {

    private TriangleUtils triangleUtils;

    @BeforeEach
    void setUp() {

        triangleUtils = new TriangleUtils();

    }

    @Nested
    @DisplayName("Testes inválidos")
    class Invalidos {

        @Test
        @DisplayName("Data nulo")
        void dataNulo() {

            assertThatThrownBy(() -> triangleUtils.computeTypeStatistics(null))
                    .isInstanceOf(NullPointerException.class);

        }

        @Test
        @DisplayName("Subarray de data maior que seis")
        void subarrayDataMaiorQueSeis() {

            double[][] data = new double[][]{{1,2,3,4,5,6,7}};
            assertThatThrownBy(() -> triangleUtils.computeTypeStatistics(data))
                    .isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        @DisplayName("Subarray de data menor que seis")
        void subarrayDataMenorQueSeis() {

            double[][] data = new double[][]{{1,2,3,4,5}};
            assertThatThrownBy(() -> triangleUtils.computeTypeStatistics(data))
                    .isInstanceOf(IllegalArgumentException.class);

        }


    }

}