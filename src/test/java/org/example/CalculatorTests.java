package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTests {
    // Test launcher
    // The more test methods, the faster the error arises
    // We have noticed that the less number of tests methods, the slower it is to trigger the error
    // After a quick glance at JUnit code, in the case of parameterized tests, not all tests are scheduled at once
    // Instead, the more tests are running, the more duplicates we see in the execution.
    // When limiting this class to doubleIntWithTask{1,2} and doubleIntWithCompleter{1,2}, it took ~45s to trigger the
    // error.

    private static Stream<Arguments> intStream() {
        return IntStream.rangeClosed(0, 100).mapToObj(Arguments::of);
    }

    @ParameterizedTest(name = "Double {0}")
    @MethodSource("intStream")
    void doubleIntWithTask1(int first) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2 * first, calculator.doubleIntWithTask(first));
    }

    @ParameterizedTest(name = "Double {0}")
    @MethodSource("intStream")
    void doubleIntWithTask2(int first) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2 * first, calculator.doubleIntWithTask(first));
    }

    @ParameterizedTest(name = "Double {0}")
    @MethodSource("intStream")
    void doubleIntWithTask3(int first) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2 * first, calculator.doubleIntWithTask(first));
    }

    @ParameterizedTest(name = "Double {0}")
    @MethodSource("intStream")
    void doubleIntWithTask4(int first) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2 * first, calculator.doubleIntWithTask(first));
    }

    @ParameterizedTest(name = "Double {0}")
    @MethodSource("intStream")
    void doubleIntWithTask5(int first) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2 * first, calculator.doubleIntWithTask(first));
    }

    @ParameterizedTest(name = "Double {0}")
    @MethodSource("intStream")
    void doubleIntWithCompleter1(int first) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2 * first, calculator.doubleIntWithCompleter(first));
    }

    @ParameterizedTest(name = "Double {0}")
    @MethodSource("intStream")
    void doubleIntWithCompleter2(int first) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2 * first, calculator.doubleIntWithCompleter(first));
    }

    @ParameterizedTest(name = "Double {0}")
    @MethodSource("intStream")
    void doubleIntWithCompleter3(int first) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2 * first, calculator.doubleIntWithCompleter(first));
    }

    @ParameterizedTest(name = "Double {0}")
    @MethodSource("intStream")
    void doubleIntWithCompleter4(int first) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2 * first, calculator.doubleIntWithCompleter(first));
    }
}
