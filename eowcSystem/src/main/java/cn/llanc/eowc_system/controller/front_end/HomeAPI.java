package cn.llanc.eowc_system.controller.front_end;

import cn.llanc.eowc_system.common.InterfaceParamUtils;
import cn.llanc.eowc_system.service.ICommonInfoService;
import cn.llanc.eowc_system.service.IHomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

import static cn.llanc.eowc_system.common.SystemConsts.*;

/**
 * @author liulc
 * @ClassName HomeAPI
 * @Description 前台页面首页
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
    @Autowired
    IHomeService homeService;

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

    /**
     * 获取轮播图
     * @return
     */
    @Path("/bannerInfo")
    @GET
    public String getBannerImage() {
        log.debug("获取轮播图");
        Map map = homeService.showBannerImage();
        return InterfaceParamUtils.getOutData(SHOW_BANNER_INFO_SUCCESS, map);
    }

    /**
     * 供应商信息
     * @return
     */
    @Path("/clientInfo")
    @GET
    public String getClientInfo() {
        log.debug("获取供应商信息");
        Map map = homeService.showClientInfo();
        return InterfaceParamUtils.getOutData(SHOW_CLIENT_INFO_SUCCESS, map);
    }

    /**
     * 获取服务信息
     * @return
     */
    @Path("/serviceInfo")
    @GET
    public String getServiceInfo() {
        log.debug("获取服务西信息");
        Map map = homeService.showServiceInfo();
        return InterfaceParamUtils.getOutData(SHOW_SERVICE_INFO_SUCCESS, map);
    }

    /**
     * 获取产品信息
     * @return
     */
    @Path("/productInfo")
    @GET
    public String getProductInfo() {
        log.debug("获取产品信息");
        Map map = homeService.showProductInfo();
        return InterfaceParamUtils.getOutData(SHOW_PRODUCT_INFO_SUCCESS, map);
    }

    /**
     * 获取客户评价
     * @return
     */
    @Path("/evaluateInfo")
    @GET
    public String getEvaluateInfo() {
        log.debug("获取客户评价");
        Map map = homeService.showEvaluateInfo();
        return InterfaceParamUtils.getOutData(SHOW_EVALUATE_INFO_SUCCESS, map);
    }

    /**
     * 获取人才队伍信息
     * @return
     */
    @Path("/talentInfo")
    @GET
    public String getTalentInfo() {
        log.debug("获取人才队伍信息");
        Map map = homeService.showTalentInfo();
        return InterfaceParamUtils.getOutData(SHOW_TALENT_INFO_SUCCESS, map);
    }

    /**
     * 获取关于我们信息
     * @return
     */
    @Path("/aboutInfo")
    @GET
    public String getAboutInfo() {
        log.debug("获取关于我们信息");
        Map map = homeService.showAboutInfo();
        return InterfaceParamUtils.getOutData(SHOW_ABOUT_INFO_SUCCESS, map);
    }

}
