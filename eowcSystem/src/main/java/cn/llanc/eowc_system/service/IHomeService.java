package cn.llanc.eowc_system.service;

import java.util.Map;

public interface IHomeService {
    /**
     * 更新信息
     * @param inparam
     * @return
     */
    String updateInfos(Map inparam);

    /**
     * 数据回显
     * @return
     */
    Map showInfos();

    /**
     * 首页轮播图更新
     * @param inparam
     * @return
     */
    String updateBannerImg(Map inparam);

    /**
     * 获取首页轮播图信息
     * @return
     */
    Map showBannerImage();

    /**
     * 获取首页供应商
     * @return
     */
    Map showClientInfo();

    /**
     * 获取首页服务
     * @return
     */
    Map showServiceInfo();

    /**
     * 获取首页产品
     * @return
     */
    Map showProductInfo();

    /**
     * 获取首页服务评论
     * @return
     */
    Map showEvaluateInfo();

    /**
     * 获取首页人才信息
     * @return
     */
    Map showTalentInfo();

    /**
     * 获取首页关于
     * @return
     */
    Map showAboutInfo();

}
