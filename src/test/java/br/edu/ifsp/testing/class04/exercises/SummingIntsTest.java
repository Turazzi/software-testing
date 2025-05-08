package br.edu.ifsp.testing.class04.exercises;

import br.edu.ifsp.testing.class04.SummingInts;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class SummingIntsTest {

    private SummingInts sut;

    @BeforeEach
    void setUp() {
        sut = new SummingInts();
    }


    @Nested
    @DisplayName("Testing invalid cases")
    class InvalidCases {

        @ParameterizedTest
        @CsvSource({
                "'-1,9', '5,0'",
                "'1,10', '5,0'"
        })
        @DisplayName("Should throw illegal argument if digit is smaller than zero or greater than nine")
        void shouldThrowIllegalArgumentIfDigitIsSmallerThanZeroOrGreaterThanNine(String leftValue, String rightValue) {

            List<Integer> left = convertStringToList(leftValue);
            List<Integer> right = convertStringToList(rightValue);

            assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                    () -> sut.add(left, right)
            );
        }

        @Nested
        @DisplayName("Testing null and empty cases")
        class NullAndEmptyCases {

            @ParameterizedTest
            @CsvSource({
                    "null, '5,0'",
                    "'5,0', null"
            })
            @DisplayName("Should return null if one of the values are null")
            void shouldReturnNullIfOneOfTheValuesAreNull(String leftValue, String rightValue) {

                List<Integer> left = convertStringToList(leftValue);
                List<Integer> right = convertStringToList(rightValue);

                List<Integer>obtained = sut.add(left, right);

                assertThat(obtained).isNull();

            }

            @ParameterizedTest
            @CsvSource({
                    "'','5,0','5,0'",
                    "'5,0','','5,0'"
            })
            @DisplayName("Should return the result of the sum if one of the values are empty")
            void shouldReturnTheResultOfTheSumIfOneOfTheValuesAreEmpty(String leftValue, String rightValue, String expected) {

                List<Integer> left = convertStringToList(leftValue);
                List<Integer> right = convertStringToList(rightValue);

                List<Integer>obtained = sut.add(left, right);

                assertThat(obtained).isEqualTo(convertStringToList(expected));

            }

        }

        @Nested
        @DisplayName("Testing valid cases")
        class ValidCases {

            @ParameterizedTest
            @CsvSource({
                    "'1,5,0','6,0','2,1,0'"
            })
            @DisplayName("must add a 3-digit value to a 2-digit value and return the correct result")
            void mustAddA3DigitValueToA2DigitValueAndReturnTheCorrectResult(String leftValue, String rightValue, String expected) {

                List<Integer> left = convertStringToList(leftValue);
                List<Integer> right = convertStringToList(rightValue);

                List<Integer> obtained = sut.add(left, right);

                assertThat(obtained).isEqualTo(convertStringToList(expected));

            }

            //The code does not do sums that increase decimal places
            @ParameterizedTest
            @CsvSource({
                    "'5,5,5','6,5,4','1,2,0,9'"
            })
            @DisplayName("Must add a 3-digit value to another 3-digit value and return a 4-digit result")
            void mustAddA3DigitValueToAnother3DigitValueAndReturnA4DigitResult(String leftValue, String rightValue, String expected) {

                List<Integer> left = convertStringToList(leftValue);
                List<Integer> right = convertStringToList(rightValue);

                List<Integer> obtained = sut.add(left, right);

                assertThat(obtained).isEqualTo(convertStringToList(expected));

            }

            @ParameterizedTest
            @CsvSource({
                    "'5,0','6,2','1,1,2'"
            })
            @DisplayName("Must add a 2-digit value to another 2-digit value and return a 3-digit result")
            void mustAddA2DigitValueToAnother2DigitValueAndReturnA3DigitResult(String leftValue, String rightValue, String expected) {

                List<Integer> left = convertStringToList(leftValue);
                List<Integer> right = convertStringToList(rightValue);

                List<Integer> obtained = sut.add(left, right);

                assertThat(obtained).isEqualTo(convertStringToList(expected));

            }

            @ParameterizedTest
            @CsvSource ({
                    "'1,9,1','9','2,0,0'"
            })
            @DisplayName("Should return the correct sum of a 3-digit value and a 1-digit value")
            void shouldReturnTheCorrectSumOfA3DigitValueAndA1DigitValue(String leftValue, String rightValue, String expected) {

                List<Integer> left = convertStringToList(leftValue);
                List<Integer> right = convertStringToList(rightValue);

                List<Integer> obtained = sut.add(left, right);

                assertThat(obtained).isEqualTo(convertStringToList(expected));

            }

        }


    }

    private List<Integer> convertStringToList(String string) {

        if("null".equals(string)) {
            return null;
        }
        else if(string.isEmpty()) {
            return List.of();
        }

        return Arrays.stream(string.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }
}
