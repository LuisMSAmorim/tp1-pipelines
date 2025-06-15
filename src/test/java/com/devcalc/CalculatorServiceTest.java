package com.devcalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void testAdd() {
        assertEquals(5.0, calculatorService.add(2.0, 3.0), "2 + 3 should equal 5");
        assertEquals(-1.0, calculatorService.add(-2.0, 1.0), "-2 + 1 should equal -1");
        assertEquals(0.0, calculatorService.add(0.0, 0.0), "0 + 0 should equal 0");
    }

    @Test
    void testSubtract() {
        assertEquals(-1.0, calculatorService.subtract(2.0, 3.0), "2 - 3 should equal -1");
        assertEquals(3.0, calculatorService.subtract(2.0, -1.0), "2 - (-1) should equal 3");
        assertEquals(0.0, calculatorService.subtract(0.0, 0.0), "0 - 0 should equal 0");
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, calculatorService.multiply(2.0, 3.0), "2 * 3 should equal 6");
        assertEquals(-2.0, calculatorService.multiply(-2.0, 1.0), "-2 * 1 should equal -2");
        assertEquals(0.0, calculatorService.multiply(10.0, 0.0), "10 * 0 should equal 0");
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculatorService.divide(6.0, 3.0), "6 / 3 should equal 2");
        assertEquals(-2.0, calculatorService.divide(-6.0, 3.0), "-6 / 3 should equal -2");
        assertEquals(0.5, calculatorService.divide(1.0, 2.0), "1 / 2 should equal 0.5");
    }

    @Test
    void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(1.0, 0.0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage(), "Exception message should match");
    }

    @Test
    void testSqrt() {
        assertEquals(4.0, calculatorService.sqrt(16.0), "sqrt(16) should equal 4");
        assertEquals(0.0, calculatorService.sqrt(0.0), "sqrt(0) should equal 0");
        assertEquals(1.4142135623730951, calculatorService.sqrt(2.0), "sqrt(2) should be close to 1.414");
    }

    @Test
    void testSqrtOfNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.sqrt(-1.0);
        });
        assertEquals("Cannot take the square root of a negative number", exception.getMessage(), "Exception message should match");
    }
}