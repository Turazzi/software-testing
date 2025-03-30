package br.edu.ifsp.testing.class03.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IdentifierTest {

    @Nested
    @DisplayName("Testing invalid cases")
    class InvalidCases {

        @Test
        @DisplayName("Should throw illegal argument if identifiers length is equal to zero")
        void shouldThrowIllegalArgumentIfIdentifiersLengthIsEqualToZero() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> { Identifier.verify("");}
            ).withMessage("The identifier has to be less than 6 characters and not empty");
        }

        @Test
        @DisplayName("Should throw illegal argument if identifier begins with one number and has length equal to 1")
        void shouldThrowIllegalArgumentIfIdentifierBeginsWithOneNumberAndHasLengthEqualTo1() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> {Identifier.verify("1");}
            ).withMessage("The identifier cannot start with a digit");
        }

        @Test
        @DisplayName("Should throw illegal argument if identifier begins with a number")
        void shouldThrowIllegalArgumentIfIdentifierBeginsWithANumber() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> {Identifier.verify("1ab");}
            ).withMessage("The identifier cannot start with a digit");
        }

        @Test
        @DisplayName("Should throw illegal argument if identifier has length greater than 6")
        void shouldThrowIllegalArgumentIfIdentifierHasLengthGreaterThan6() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> {Identifier.verify("abcdefg");}
            ).withMessage("The identifier has to be less than 6 characters and not empty");
        }

        @Test
        @DisplayName("Should throw illegal argument if identifier contains whitespace")
        void shouldThrowIllegalArgumentIfIdentifierContainsWhitespace() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> {Identifier.verify("a bc");}
            ).withMessage("The identifier must contain only letters and digits");
        }

        @Test
        @DisplayName("Should throw illegal argument if identifier contains special characters")
        void shouldThrowIllegalArgumentIfIdentifierContainsSpecialCharacters() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> {Identifier.verify("a@bc");}
            ).withMessage("The identifier must contain only letters and digits");
        }

        @Test
        @DisplayName("Should throw illegal argument if identifier contains punctuation")
        void shouldThrowIllegalArgumentIfIdentifierContainsPunctuation() {
            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> {Identifier.verify("a!bc");}
            ).withMessage("The identifier must contain only letters and digits");
        }

    }

    @Nested
    @DisplayName("Testing valid cases")
    class ValidCases {

        @Test
        @DisplayName("Should identifier be valid if has length equal to 6")
        void shouldIdentifierBeValidIfHasLengthEqualTo6() {
            assertThat(Identifier.verify("a1b2c3")).isTrue();
        }

        @Test
        @DisplayName("Should identifier be valid if has length equal to 1 and start with a letter")
        void shouldIdentifierBeValidIfHasLengthEqualTo1AndStartWithALetter() {
            assertThat(Identifier.verify("a")).isTrue();
        }

    }

}
