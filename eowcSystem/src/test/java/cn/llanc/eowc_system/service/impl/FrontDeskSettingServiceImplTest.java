package cn.llanc.eowc_system.service.impl;

import cn.llanc.eowc_system.EowcSystemApplicationTests;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

public class FrontDeskSettingServiceImplTest extends EowcSystemApplicationTests {

    @Autowired
    FrontDeskSettingServiceImpl frontDeskSettingService;

    @Test
    public void updateInfos() {

    }

    @Test
    public void showInfos() {
        Map map = frontDeskSettingService.showInfos();
        System.out.println(JSONObject.toJSONString(map, WriteMapNullValue));
    }
}