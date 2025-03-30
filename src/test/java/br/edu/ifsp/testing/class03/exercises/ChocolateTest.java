package br.edu.ifsp.testing.class03.exercises;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


class ChocolateTest {

    @Nested
    @DisplayName("Testing invalid cases")
    class InvalidCases {

        @Test
        @DisplayName("Should throw illegal argument if M is equal or smaller than 1")
        void shouldThrowIllegalArgumentIfMIsEqualOrSmallerThan1() {
            SoftAssertions softly = new SoftAssertions();

            softly.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> Chocolate.calculateTotalOfChocolates(5, 1, 0)
            ).withMessage("m must be greater than 1");

            softly.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> Chocolate.calculateTotalOfChocolates(5, 1, -1)
            ).withMessage("m must be greater than 1");

            softly.assertAll();
        }

        @Test
        @DisplayName("Should throw illegal argument if C is equal or smaller than 0")
        void shouldThrowIllegalArgumentIfCIsEqualOrSmallerThan0() {
            SoftAssertions softly = new SoftAssertions();

            softly.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> Chocolate.calculateTotalOfChocolates(5, 0, 2)
            ).withMessage("c must be greater than 0");

            softly.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> Chocolate.calculateTotalOfChocolates(5,-1,3)
            ).withMessage("c must be greater than 0");

            softly.assertAll();
        }

        @Test
        @DisplayName("Should throw illegal argument if N is smaller than 0")
        void shouldThrowIllegalArgumentIfNIsSmallerThan0() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> Chocolate.calculateTotalOfChocolates(-52, 1, 0)
            ).withMessage("n must be greater than 0");
        }

    }

    @Nested
    @DisplayName("Testing valid cases")
    class ValidCases {

        @Test
        @DisplayName("Should not allow to buy any chocolate when n is equal to 0")
        void shouldNotAllowToBuyAnyChocolateWhenNIsEqualTo0() {
            assertThat(Chocolate.calculateTotalOfChocolates(0,1,3)).isEqualTo(0);
        }

        @Test
        @DisplayName("Should buy exactly one chocolate")
        void shouldBuyExactlyOneChocolate() {
            assertThat(Chocolate.calculateTotalOfChocolates(5,5,2)).isEqualTo(1);
        }

        @Test
        @DisplayName("Should take exactly one chocolate extra")
        void shouldTakeExactlyOneChocolateExtra() {
            assertThat(Chocolate.calculateTotalOfChocolates(10,2,5)).isEqualTo(6);
        }

        @Test
        @DisplayName("Should take chocolates extra more than once")
        void shouldTakeChocolatesExtraMoreThanOnce() {
            assertThat(Chocolate.calculateTotalOfChocolates(100,10,2)).isEqualTo(19);
        }

        @Test
        @DisplayName("Should buy exactly one chocolate with change")
        void shouldBuyExactlyOneChocolateWithChange() {
            assertThat(Chocolate.calculateTotalOfChocolates(3,2,3)).isEqualTo(1);
        }

        @Test
        @DisplayName("Should trade all the packages without nothing left")
        void shouldTradeAllThePackagesWithoutNothingLeft() {
            assertThat(Chocolate.calculateTotalOfChocolates(10,5,2)).isEqualTo(3);
        }

    }

}