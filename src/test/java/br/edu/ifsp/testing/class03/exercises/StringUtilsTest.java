package br.edu.ifsp.testing.class03.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    @DisplayName("Should a null str return null")
    void shouldANullStrReturnNull() {
        assertThat(StringUtils.substringsBetween(null, "jao", "maria")).isNull();
    }

    @Test
    @DisplayName("Should a empty str return empty string array")
    void shouldAEmptyStrReturnEmptyStringArray() {
        assertThat(StringUtils.substringsBetween("", "jao", "maria")).isEmpty();
    }

    @Test
    @DisplayName("Should an empty open return null")
    void shouldAnEmptyOpenReturnNull() {
        assertThat(StringUtils.substringsBetween("ab", "", "b")).isNull();
    }

    @Test
    @DisplayName("Should a null open return null")
    void shouldANullOpenReturnNull() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(
                () -> StringUtils.substringsBetween("ab", null, "a")
        );
    }

    @Test
    @DisplayName("Should an empty close return null")
    void shouldAnEmptyCloseReturnNull() {
        assertThat(StringUtils.substringsBetween("ab", "a", "")).isNull();
    }

    @Test
    @DisplayName("Should a null close return null")
    void shouldANullCloseReturnNull() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(
                () -> StringUtils.substringsBetween("ab", "a", null)
        );
    }

    @Test
    @DisplayName("Should str with length 1 return null when is equal to open and different to close")
    void shouldStrWithLength1ReturnNullWhenIsEqualToOpenAndDifferentToClose() {
        assertThat(StringUtils.substringsBetween("a", "a", "b")).isNull();
    }

    @Test
    @DisplayName("Should str with length 1 return null when is equal to open and close")
    void shouldStrWithLength1ReturnNullWhenIsEqualToOpenAndClose() {
        assertThat(StringUtils.substringsBetween("a", "a", "a")).isNull();
    }

    @Test
    @DisplayName("Should str with length 1 return null when is different to open and close")
    void shouldStrWithLength1ReturnNullWhenIsDifferentToOpenAndClose() {
        assertThat(StringUtils.substringsBetween("a", "b", "b")).isNull();
    }

    @Test
    @DisplayName("Should str with length 1 return null when is different to open and equal to close")
    void shouldStrWithLength1ReturnNullWhenIsDifferentToOpenAndEqualToClose() {
        assertThat(StringUtils.substringsBetween("a", "b", "a")).isNull();
    }

    @Test
    @DisplayName("Should return only one substring")
    void shouldReturnOnlyOneSubstring() {
        assertThat(StringUtils.substringsBetween("abcde", "a", "d")).containsExactly("bc");
    }

    @Test
    @DisplayName("Should return null when dont have any substring")
    void shouldReturnNullWhenDontHaveAnySubstring() {
        assertThat(StringUtils.substringsBetween("abcde", "f", "g")).isNull();
    }

    @Test
    @DisplayName("Should return all the substrings")
    void shouldReturnAllTheSubstrings() {
        assertThat(StringUtils.substringsBetween("abdcdacbddaghbd", "a", "bd")).containsExactly("", "c", "gh");
    }

    @Test
    @DisplayName("Should return the spaces between open and close in the substring")
    void shouldReturnTheSpacesBetweenOpenAndCloseInTheSubstring() {
        assertThat(StringUtils.substringsBetween("ab  c", "a", "c")).containsExactly("b  ");
    }

    @Test
    @DisplayName("Should return null when str contains open and no close")
    void shouldReturnNullWhenStrContainsOpenAndNoClose() {
        assertThat(StringUtils.substringsBetween("abc", "a", "d")).isNull();
    }

    @Test
    @DisplayName("Should return null when str contains close and no open")
    void shouldReturnNullWhenStrContainsCloseAndNoOpen() {
        assertThat(StringUtils.substringsBetween("abc", "d", "a")).isNull();
    }

    @Test
    @DisplayName("Should return null when str has no open and close")
    void shouldReturnNullWhenStrHasNoOpenAndClose() {
        assertThat(StringUtils.substringsBetween("abc", "d", "e")).isNull();
    }

    @Test
    @DisplayName("Should return an empty substring when str contains open and close but no substring between them")
    void shouldReturnNullWhenStrContainsOpenAndCloseButNoSubstringBetweenThem() {
        assertThat(StringUtils.substringsBetween("abc", "a", "b")).containsExactly("");
    }

}