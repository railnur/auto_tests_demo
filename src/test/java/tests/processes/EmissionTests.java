package tests.processes;

import org.junit.Test;
import tests.BaseTest;

public class EmissionTests extends BaseTest{

    @Test
    public void ContractEmissionTest () throws Exception {
        configProps.setOrderType(2);

        postBasestate(11, true);
    }

    @Test
    public void OwnerEmissionTest () throws Exception {
        configProps.setOrderType(1);
        postBasestate(11, true);
    }

    @Test
    public void ForeignEmissionTest () throws Exception {
        postBasestate(22, true);
    }

    @Test
    public void RelabelEmissionTest () throws Exception{
        postBasestate(11, true);
        postBasestate(65, true);
    }
}
