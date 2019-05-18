package cn.llanc.eowc_system.service;

import java.util.Map;

/**
 * @author liulc
 * @ClassName IFrontDeskSettingService
 * @Description 前台设置接口
 * @date 2019/05/17
 **/
public interface IFrontDeskSettingService {

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

}
