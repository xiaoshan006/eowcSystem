package cn.llanc.eowc_system.controller;

import cn.llanc.eowc_system.common.InterfaceParamUtils;
import cn.llanc.eowc_system.service.IFrontDeskSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

import static cn.llanc.eowc_system.common.SystemConsts.*;

/**
 * @author liulc
 * @ClassName FrontDeskSettingAPI
 * @Description TODO
 * @date 2019/05/17
 **/
@Slf4j
@Component
@Path("/frontSetting")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrontDeskSettingAPI {
    @Autowired
    IFrontDeskSettingService iFrontDeskSettingService;

    /**
     * 前台数据回显
     * @return
     */
    @Path("/showInfo")
    @GET
    public String shwoInfo() {
        log.debug("获取前台数据信息");
        Map map = iFrontDeskSettingService.showInfos();
        return InterfaceParamUtils.getOutData(SHOW_INFO_SUCCESS, map);
    }

    /**
     * 前台信息更新
     * @param inparm
     * @return
     */
    @Path("/updateInfo")
    @PUT
    public String updateInfo(Map inparm) {
        log.debug("入参校验");
        if (null == inparm) {
            return InterfaceParamUtils.getOutData(UPDATE_INFO_ERROR, null);
        }
        log.debug("数据更新服务调用");
        String resultCode = iFrontDeskSettingService.updateInfos(inparm);

        if (UPDATE_INFO_SUCCESS.getStateCode().equals(resultCode)) {
            return InterfaceParamUtils.getOutData(UPDATE_INFO_SUCCESS, null);
        } else {
            return InterfaceParamUtils.getOutData(UPDATE_INFO_ERROR, null);
        }
    }

}
