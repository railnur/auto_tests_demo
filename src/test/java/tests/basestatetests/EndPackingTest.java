package tests.basestatetests;

import org.junit.Test;
import tests.BaseTest;




public class EndPackingTest extends BaseTest {



    @Test
    public void createKizsTest(){

        postBasestate(11);
        postBasestate(12);
        postBasestate(31);
        postBasestate(32);

    }
}
