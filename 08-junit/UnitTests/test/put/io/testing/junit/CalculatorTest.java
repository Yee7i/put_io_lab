package put.io.testing.junit;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {

    private static Calculator calc = null;

    @BeforeClass
    public static void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        Integer actual = calc.add(15, 10);
        Integer expected = 25;
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        Integer actual = calc.multiply(2, 2);
        Integer expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void testPositive()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calc.addPositiveNumbers(-1, 1));
    }

}