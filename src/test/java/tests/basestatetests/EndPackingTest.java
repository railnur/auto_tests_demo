package tests.basestatetests;

import org.junit.*;
import tests.BaseTest;
import config.Configuration;



public class EndPackingTest extends BaseTest {

    @Test
    public void createKizsTest() throws Exception {
        for (int i = 0; i < new Configuration().getSEQUENCE().length; i++) postBasestate(new Configuration().getSEQUENCE()[i], true);
    }
}
