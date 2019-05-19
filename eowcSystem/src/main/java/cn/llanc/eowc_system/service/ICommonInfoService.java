package cn.llanc.eowc_system.service;

import java.util.Map;

/**
 * @author liulc
 * @ClassName ICommonInfoService
 * @Description 公共信息获取接口
 * @date 2019/05/19
 **/
public interface ICommonInfoService {
    /**
     * 获取前台头部信息方法
     * @return
     */
    Map getHeaderInfo();

    /**
     * 获取前台页脚信息方法
     * @return
     */
    Map getFooterInfo();

    /**
     * 获取后台公共信息方法
     * @return
     */
    Map getBackCommonInfo();
}
