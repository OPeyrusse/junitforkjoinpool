package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTests {

    private static Stream<Arguments> intStream() {
        return IntStream.rangeClosed(0, 100).mapToObj(Arguments::of);
//        return Stream.of(Arguments.of(1));
    }

    @ParameterizedTest(name = "Double {0}")
    @MethodSource("intStream")
    void doubleIntWithTask(int first) throws Exception {
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
    void doubleIntWithCompleter(int first) throws Exception {
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
