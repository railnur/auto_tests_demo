package tests.processes;

import org.junit.Test;
import tests.BaseTest;

public class EmissonTests extends BaseTest{

    @Test
    public void ContractEmissonTest () throws Exception {
        myLog.info("======================= Run " + name.getMethodName() + " ============================");
        configProps.setOrderType(2);
        postBasestate(11, true);
        myLog.info("======================= Exit " + name.getMethodName() + " ============================");
    }

    @Test
    public void OwnerEmissonTest () throws Exception {
        myLog.info("======================= Run " + name.getMethodName() + " ============================");
        configProps.setOrderType(1);
        postBasestate(11, true);
        myLog.info("======================= Exit " + name.getMethodName() + " ============================");
    }

    @Test
    public void ForeignEmissonTest () throws Exception {
        myLog.info("======================= Run " + name.getMethodName() + " ============================");
        postBasestate(22, true);
        myLog.info("======================= Exit " + name.getMethodName() + " ============================");
    }
}
