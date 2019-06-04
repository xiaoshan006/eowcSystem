package cn.llanc.eowc_system.service.impl;

import cn.llanc.eowc_system.EowcSystemApplicationTests;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CommonInfoServiceImplTest extends EowcSystemApplicationTests {

    @Test
    public void getHeaderInfo() {
        CommonInfoServiceImpl commonInfoServiceImp = new CommonInfoServiceImpl();
        Map<String, String> headerInfo = commonInfoServiceImp.getFooterInfo();
        System.out.println(headerInfo.toString());


    }
}