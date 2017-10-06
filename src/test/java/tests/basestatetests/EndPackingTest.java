package tests.basestatetests;

import org.junit.*;
import tests.BaseTest;




public class EndPackingTest extends BaseTest {



    @Test
    public void createKizsTest() throws Exception {
        postBasestate(11, true);
        postBasestate(12, true);
        postBasestate(31, true);
    }
}
