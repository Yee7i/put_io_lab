package put.io.testing.audiobooks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    AudiobookPriceCalculator audiobookPriceCalculator = new  AudiobookPriceCalculator();

    @Test
    public void test1(){
        Customer customer = new Customer("", Customer.LoyaltyLevel.GOLD, true);
        assertEquals(0.0, audiobookPriceCalculator.calculate(customer, new Audiobook("", 1)));
    }

    @Test
    public void test2(){
        Customer customer = new Customer("", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(0.8, audiobookPriceCalculator.calculate(customer, new Audiobook("", 1)));
    }

    @Test
    public void test3(){
        Customer customer = new Customer("", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(0.9, audiobookPriceCalculator.calculate(customer, new Audiobook("", 1)));
    }

    @Test
    public void test4(){
        Customer customer = new Customer("", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(1, audiobookPriceCalculator.calculate(customer, new Audiobook("", 1)));
    }
}