package cn.llanc.eowc_system.controller.front_end;

import cn.llanc.eowc_system.common.InterfaceParamUtils;
import cn.llanc.eowc_system.service.ICommonInfoService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

import static cn.llanc.eowc_system.common.SystemConsts.GET_INFORMATION_SUCCESS;

/**
 * @author liulc
 * @ClassName HomeAPI
 * @Description TODO
 * @date 2019/05/19
 **/
@Slf4j
@Component
@Path("/home")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HomeAPI {

    @Autowired
    ICommonInfoService commonInfoService;

    /**
     * 获取前台头部信息接口
     * @return
     */
    @Path("/heardInfo")
    @GET
    public String getHeaderInfo() {
        log.debug("获取前台头部信息");
        Map heardInfo = commonInfoService.getHeaderInfo();
        return InterfaceParamUtils.getOutData(GET_INFORMATION_SUCCESS, heardInfo);
    }

    /**
     * 获取前台页脚信息
     * @return
     */
    @Path("/footerInfo")
    @GET
    public String getFooterInfo() {
        log.debug("获取前台页脚信息");
        Map footerInfo = commonInfoService.getFooterInfo();
        return InterfaceParamUtils.getOutData(GET_INFORMATION_SUCCESS, footerInfo);
    }


    /**
     * 获取公司信息（公司名称）
     * @return
     */
    @Path("/commonBackInfo")
    @GET
    public String getCompanyName() {
        log.debug("获取公司名称");
        Map companyName = commonInfoService.getBackCommonInfo();
        return InterfaceParamUtils.getOutData(GET_INFORMATION_SUCCESS, companyName);
    }

}
