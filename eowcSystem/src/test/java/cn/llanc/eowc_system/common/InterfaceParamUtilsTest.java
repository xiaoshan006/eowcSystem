package cn.llanc.eowc_system.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterfaceParamUtilsTest {

    @Test
    public void getOutData() {
        String str = InterfaceParamUtils.getOutData("000", "sdasdasd", null);
        System.out.println(str);
    }
}