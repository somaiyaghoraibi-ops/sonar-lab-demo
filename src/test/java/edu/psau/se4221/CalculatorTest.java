package edu.psau.se4221;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void addsTwoNumbers() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void subtractsTwoNumbers() {
        assertEquals(1, calc.subtract(3, 2));
    }

    // Students: add tests for multiply() and divide()
    // to push coverage above 80% and satisfy the Quality Gate.
}
