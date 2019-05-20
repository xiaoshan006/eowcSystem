package cn.llanc.eowc_system.common;

import cn.llanc.eowc_system.EowcSystemApplicationTests;
import org.junit.Test;


public class SMSUtilsTest extends EowcSystemApplicationTests {

    @Test
    public void sendSms() {
        String code = SMSUtils.sendSms("17853583892");
        System.out.println(code);

    }
}