package cn.llanc.eowc_system.service;

import java.util.Map;

public interface IHomeSettingService {
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
