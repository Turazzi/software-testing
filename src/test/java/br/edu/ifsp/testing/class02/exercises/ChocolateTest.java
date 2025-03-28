package br.edu.ifsp.testing.class02.exercises;

import io.opentelemetry.semconv.OtelAttributes;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChocolateTest {

    @Test
    @DisplayName("Should throw exception when M  is less than or equal to one")
    void shouldThrowExceptionWhenMIsLessThanOrEqualToOne() {
         Chocolate chocolate = new Chocolate();
        SoftAssertions softly = new SoftAssertions();

        softly.assertThatThrownBy(() -> chocolate.calculateTotalOfChocolates(5,2,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("M must be greater than 1");
        softly.assertThatThrownBy(() -> chocolate.calculateTotalOfChocolates(5,2,1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("M must be greater than 1");
        softly.assertAll();
    }

    @Test
    @DisplayName("Should throw exception when C is less than or equal to zero")
    void shouldThrowExceptionWhenCIsLessThanOrEqualToZero() {
        Chocolate chocolate = new Chocolate();
        SoftAssertions softly = new SoftAssertions();

        softly.assertThatThrownBy(() -> chocolate.calculateTotalOfChocolates(5,0,2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("C must be greater than 0");
        softly.assertThatThrownBy(() -> chocolate.calculateTotalOfChocolates(5,-1,2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("C must be greater than 0");
        softly.assertAll();
    }

    @Test
    @DisplayName("Should throw exception when N is less than zero")
    void shouldThrowExceptionWhenNIsLessThanZero() {
        Chocolate chocolate = new Chocolate();

        Assertions.assertThatThrownBy(() -> chocolate.calculateTotalOfChocolates(-1,1,3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("N must be greater than or equal to 0");
    }

    @Test
    @DisplayName("Should buy exactly one chocolate without exchanges")
    void shouldBuyExactlyOneChocolateWithoutExchanges() {
        final int result = new Chocolate().calculateTotalOfChocolates(5, 5, 2);

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Should exchange exactly one packaging")
    void shouldExchangeExactlyOnePackaging() {
        final int result = new Chocolate().calculateTotalOfChocolates(10,2,5);

        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Should exchange more than once with the packages obtained from exchange")
    void shouldExchangeMoreThanOnceWithThePackagesObtainedFromExchange() {
        final int result = new Chocolate().calculateTotalOfChocolates(100,10,2);
        
        Assertions.assertThat(result).isEqualTo(19);
    }

    @Test
    @DisplayName("Should buy only one chocolate")
    void shouldBuyOnlyOneChocolate() {
        final int result = new Chocolate().calculateTotalOfChocolates(3,2,3);
        
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Should exchange exactly without any leftover package")
    void shouldExchangeExactlyWithoutAnyLeftoverPackage() {
        final int result = new Chocolate().calculateTotalOfChocolates(10,5,2);

        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Should return zero because N is equal to zero")
    void shouldReturnZeroBecauseNIsEqualToZero() {
        final int result = new Chocolate().calculateTotalOfChocolates(0,2,5);

        Assertions.assertThat(result).isEqualTo(0);
    }
    
}