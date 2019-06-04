package cn.llanc.eowc_system.common;

import cn.llanc.eowc_system.EowcSystemApplicationTests;
import org.junit.Test;


public class SMSUtilsTest extends EowcSystemApplicationTests {

    @Test
    public void sendSms() {
        String phone = "18754868903";
        System.out.println("入参手机号码为："+phone);
        String code = SMSUtils.sendSms(phone);
        System.out.println("发送的验证码为:"+code);
    }
}