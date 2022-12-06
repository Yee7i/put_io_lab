package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class FailureOrErrorTest {

    @Test
    public void test1(){
        Assertions.assertTrue(false);
    }

    @Test
    public void test2() throws IOException {
        throw new IOException("ha");
    }

    @Test
    public void test3() {
        try {
            Assertions.assertTrue(false);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
}