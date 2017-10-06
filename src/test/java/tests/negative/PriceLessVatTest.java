package tests.negative;

import org.junit.Test;
import tests.BaseTest;

public class PriceLessVatTest extends BaseTest{


    @Test(expected = AssertionError.class)
    public void test_321_321() throws Exception {
        postBasestate(22, true);
        postBasestate(32, true);
    }


}

