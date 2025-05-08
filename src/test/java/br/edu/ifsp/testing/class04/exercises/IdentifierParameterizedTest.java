package br.edu.ifsp.testing.class04.exercises;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.suite.api.*;
import org.springframework.beans.factory.annotation.Value;

public class IdentifierParameterizedTest {

    @Suite
    @SelectPackages("package br.edu.ifsp.testing.class03.exercises")
    @SuiteDisplayName("All unit tests")
    @IncludeTags("UnitTest")
    public class AllUnitTests {

        @Nested
        @DisplayName("Testing invalid cases")
        class InvalidCases {
            
            @ParameterizedTest @Tag("UnitTest")
            @EmptySource
            @ValueSource(strings = {"", "abcdefg"})
            @Test
            @DisplayName("Should throw illegal argument")
            void shouldThrowIllegalArgument() {
                
                org.junit.jupiter.api.Assertions.fail();
            }
            
        }

    }

}
