package cn.llanc.eowc_system.common;

import cn.llanc.eowc_system.EowcSystemApplicationTests;
import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilsTest extends EowcSystemApplicationTests {

    /**
     * 密码加盐MD5处理测试
     */
    @Test
    public void generate() {
        String pwd = "123";
        System.out.println("入参密码为："+pwd);
        String md5Pwd = MD5Utils.generate(pwd);
        System.out.println("加密后密码为" + md5Pwd);
        System.out.println("请求验证密码：123");
        System.out.println("---验证开始---");
        boolean verify = MD5Utils.verify("123", md5Pwd);
        System.out.println("验证是否通过？---"+verify);
    }

    @Test
    public void verify() {
    }
}