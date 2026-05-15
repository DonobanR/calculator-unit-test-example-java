package ec.edu.epn.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class CalculatorDynamicTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsForSum() {

        int[][] data = new int[][]{
                {2, 2, 4},
                {5, 4, 9},
                {6, 4, 10},
                {-1, 1, 0}
        };

        return Arrays.stream(data).map(item -> {
            int a = item[0];
            int b = item[1];
            int expected = item[2];

            return dynamicTest("Sumando " + a + " + " + b,
                    () -> assertEquals(expected, calculator.sum(a, b))
            );
        });
    }
}