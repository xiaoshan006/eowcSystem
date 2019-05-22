package cn.llanc.eowc_system.service.impl;

import cn.llanc.eowc_system.common.MapEntityConvert;
import cn.llanc.eowc_system.domain.HomePageConfig;
import cn.llanc.eowc_system.mapper.HomePageConfigMapper;
import cn.llanc.eowc_system.service.IHomeSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static cn.llanc.eowc_system.common.SystemConsts.*;

@Transactional
@Slf4j
@Service("IHomeSettingService")
public class HomeSettingServiceImpl implements IHomeSettingService {

    @Autowired
    HomePageConfigMapper homePageConfigMapper;


    @Override
    public String updateInfos(Map inparam) {
        //入参转对象
        HomePageConfig homePageConfig = null;
        try {
            homePageConfig = (HomePageConfig) MapEntityConvert.mapToObject(inparam, HomePageConfig.class);
        } catch (Exception e) {
            log.debug("对象转换异常",e);
            return UPDATE_HOME_PAGE_SETTING_ERROR.getStateCode();
        }
        //设置主键
        homePageConfig.setHId(1);
        int count = homePageConfigMapper.updateByPrimaryKeySelective(homePageConfig);
        if (1 == count) {
            return UPDATE_HOME_PAGE_SETTING_SUCCESS.getStateCode();
        }
        return UPDATE_HOME_PAGE_SETTING_ERROR.getStateCode();
    }

    @Override
    public Map showInfos() {
        HomePageConfig homePageConfig = homePageConfigMapper.selectByPrimaryKey(1);
        Map<String, Object> resultMap = MapEntityConvert.objectToMap(homePageConfig);
        return resultMap;
    }
}
