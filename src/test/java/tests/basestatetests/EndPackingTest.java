package tests.basestatetests;

import org.junit.Test;
import tests.BaseTest;




public class EndPackingTest extends BaseTest {



    @Test
    public void createKizsTest(){

        postBasestate(22);
        checkAccept();
        postBasestate(52);
        checkReject();

    }
}
