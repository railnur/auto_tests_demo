package tests.negative;

import org.junit.Test;
import tests.BaseTest;

public class PriceLessVatTest extends BaseTest{



    @Test(expected = AssertionError.class)
    public void test_321_321() throws Exception {
        postBasestate(22, true);
        postBasestate(23, true);
    }


    @Test(expected = AssertionError.class)
    public void test__321() throws Exception {
        postBasestate(11, true);
        postBasestate(12, true);
        setVatValue(70000);
        postBasestate(31, true);
    }



}

