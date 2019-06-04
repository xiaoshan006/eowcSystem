package cn.llanc.eowc_system.controller.back_end.setting;

import cn.llanc.eowc_system.common.InterfaceParamUtils;
import cn.llanc.eowc_system.service.IHomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

import static cn.llanc.eowc_system.common.SystemConsts.*;

@Slf4j
@Component
@Path("/homePageSetting")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HomePageSettingAPI {
    @Autowired
    IHomeService iHomeService;

    /**
     * 前台数据回显
     *
     * @return
     */
    @Path("/showHomePageInfo")
    @GET
    public String shwoInfo() {
        log.debug("获取前台数据信息");
        Map map = iHomeService.showInfos();
        return InterfaceParamUtils.getOutData(SHOW_HOME_PAGE_CONFIG_SUCCESS, map);
    }

    /**
     * 前台信息更新
     *
     * @param inparam
     * @return
     */
    @Path("/setting")
    @PUT
    public String updateInfo(Map inparam) {
        log.debug("入参校验");
        if (null == inparam) {
            return InterfaceParamUtils.getOutData(UPDATE_HOME_PAGE_CONFIG_ERROR, null);
        }
        log.debug("数据更新服务调用");
        String resultCode = iHomeService.updateInfos(inparam);

        if (UPDATE_HOME_PAGE_CONFIG_SUCCESS.getStateCode().equals(resultCode)) {
            return InterfaceParamUtils.getOutData(UPDATE_HOME_PAGE_CONFIG_SUCCESS, null);
        } else {
            return InterfaceParamUtils.getOutData(UPDATE_HOME_PAGE_CONFIG_ERROR, null);
        }
    }


    @Path("/settingBanner")
    @PUT
    public String updateBannerImg(Map inparam) {
        log.debug("入参校验");
        if (null == inparam) {
            return InterfaceParamUtils.getOutData(UPDATE_BANNER_IMAGE_ERROR, null);
        }

        log.debug("数据更新服务调用");
        String resultCode = iHomeService.updateBannerImg(inparam);

        if (UPDATE_BANNER_IMAGE_SUCCESS.getStateCode().equals(resultCode)) {
            return InterfaceParamUtils.getOutData(UPDATE_BANNER_IMAGE_SUCCESS, null);
        } else {
            return InterfaceParamUtils.getOutData(UPDATE_BANNER_IMAGE_ERROR, null);
        }
    }

}
