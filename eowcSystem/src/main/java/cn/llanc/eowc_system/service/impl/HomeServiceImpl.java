package cn.llanc.eowc_system.service.impl;

import cn.llanc.eowc_system.common.MapEntityConvert;
import cn.llanc.eowc_system.domain.BannerImageInfo;
import cn.llanc.eowc_system.domain.HomePageConfig;
import cn.llanc.eowc_system.mapper.BannerImageInfoMapper;
import cn.llanc.eowc_system.mapper.HomePageConfigMapper;
import cn.llanc.eowc_system.service.IHomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.llanc.eowc_system.common.SystemConsts.*;

@Transactional
@Slf4j
@Service("IHomeService")
public class HomeServiceImpl implements IHomeService {

    @Autowired
    HomePageConfigMapper homePageConfigMapper;
    @Autowired
    BannerImageInfoMapper bannerImageInfoMapper;


    /**
     * 配置信息更新
     * @param inparam
     * @return
     */
    @Override
    public String updateInfos(Map inparam) {
        //入参转对象
        HomePageConfig homePageConfig = null;
        try {
            homePageConfig = (HomePageConfig) MapEntityConvert.mapToObject(inparam, HomePageConfig.class);
        } catch (Exception e) {
            log.debug("对象转换异常",e);
            return UPDATE_HOME_PAGE_CONFIG_ERROR.getStateCode();
        }
        //设置主键
        homePageConfig.setHId(1);
        int count = homePageConfigMapper.updateByPrimaryKeySelective(homePageConfig);
        if (1 == count) {
            return UPDATE_HOME_PAGE_CONFIG_SUCCESS.getStateCode();
        }
        return UPDATE_HOME_PAGE_CONFIG_ERROR.getStateCode();
    }

    /**
     * 配置信息回显
     * @return
     */
    @Override
    public Map showInfos() {
        HomePageConfig homePageConfig = homePageConfigMapper.selectByPrimaryKey(1);
        Map<String, Object> resultMap = MapEntityConvert.objectToMap(homePageConfig);
        return resultMap;
    }

    /**
     * 轮播图更新
     * @param inparam
     * @return
     */
    @Override
    public String updateBannerImg(Map inparam) {
        BannerImageInfo bannerImageInfo = null;
        try {
            bannerImageInfo = (BannerImageInfo) MapEntityConvert.mapToObject(inparam, BannerImageInfo.class);
        } catch (Exception e) {
            log.debug("对象转换异常",e);
            return UPDATE_BANNER_IMAGE_ERROR.getStateCode();
        }
        log.debug("更新");
        int count = bannerImageInfoMapper.updateByPrimaryKeySelective(bannerImageInfo);

        if (1 == count) {
            return UPDATE_BANNER_IMAGE_ERROR.getStateCode();
        }
        return UPDATE_BANNER_IMAGE_SUCCESS.getStateCode();
    }

    /**
     * 获取首页轮播图信息
     *
     * @return
     */
    @Override
    public Map showBannerImage() {
        List<BannerImageInfo> bannerInfos = bannerImageInfoMapper.findAll();
        List<Map> resultList = new ArrayList<>();
        for (BannerImageInfo bannerInfo : bannerInfos) {
            resultList.add(MapEntityConvert.objectToMap(bannerInfo));
        }
        Map resultMap = new HashMap();
        resultMap.put("banner", resultList);
        return resultMap;
    }

    /**
     * 获取模块显示状态
     * @param key
     */
    public Map getShowState(String key) {
        Map map = showInfos();
        String hServiceDiv = map.get(key).toString();
        Map resultMap = new HashMap();
        resultMap.put("isShow", hServiceDiv);
        return resultMap;
    }

    /**
     * 获取首页供应商
     * @return
     */
    @Override
    public Map showClientInfo() {
        return getShowState("hClientDiv");
    }

    /**
     * 服务信息
     * @return
     */
    @Override
    public Map showServiceInfo() {
        return getShowState("hServiceDiv");
    }

    /**
     * 产品信息
     * @return
     */
    @Override
    public Map showProductInfo() {
        return getShowState("hProductDiv");
    }

    /**
     * 评价
     * @return
     */
    @Override
    public Map showEvaluateInfo() {
        return getShowState("hEvaluateDiv");
    }

    /**
     * 人才队伍
     * @return
     */
    @Override
    public Map showTalentInfo() {
        return getShowState("hTalentDiv");
    }

    /**
     * 关于
     * @return
     */
    @Override
    public Map showAboutInfo() {
        return getShowState("hAboutUsDiv");
    }


}
