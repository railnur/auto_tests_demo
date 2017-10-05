package tests.basestatetests;

import org.junit.*;
import tests.BaseTest;




public class EndPackingTest extends BaseTest {



    @Test
    public void createKizsTest() throws Exception {
        for (int i = 0; i < SEQUENCE.length; i++) postBasestate(SEQUENCE[i], true);
    }
}
