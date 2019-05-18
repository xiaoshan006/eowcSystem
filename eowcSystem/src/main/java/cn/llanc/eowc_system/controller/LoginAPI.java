package cn.llanc.eowc_system.controller;

import cn.llanc.eowc_system.common.InterfaceParamUtils;
import cn.llanc.eowc_system.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

import static cn.llanc.eowc_system.common.SystemConsts.*;
import static cn.llanc.eowc_system.common.SystemConsts.USER_IS_LOINGED;

/**
 * @author liulc
 * @ClassName LoginAPI
 * @Description TODO
 * @date 2019/05/16
 **/
@Slf4j
@Component
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginAPI {
    @Autowired
    private ILoginService LoginService;

    /**
     * 登录校验API
     * @param inparam
     * @param request
     * @return
     */
    @Path("/loginAuthentication")
    @POST
    public String loginAuthentication(Map inparam, @Context HttpServletRequest request) {
        log.debug("入参校验");
        String userName = null;
        String password = null;
        try {
            userName = inparam.get("userName").toString();
            password = inparam.get("password").toString();
        } catch (Exception e) {
            log.debug("入参为空");
            return InterfaceParamUtils.getOutData(LOGIN_ERROR.getStateCode(), LOGIN_ERROR.getStateMsg(), null);
        }
        if (null == userName || "" == userName || null == password || "" == password) {
            return InterfaceParamUtils.getOutData(LOGIN_ERROR.getStateCode(), LOGIN_ERROR.getStateMsg(), null);
        }
        log.debug("用户名密码校验");
        String role = LoginService.loginVerification(userName, password);
        if (LOGIN_ERROR.getStateCode().equals(role)) {
            return InterfaceParamUtils.getOutData(LOGIN_ERROR.getStateCode(), LOGIN_ERROR.getStateMsg(), null);
        }
        log.debug("用户名密码校验通过");

        log.debug("设置Session");
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);
        session.setAttribute("role", role);

        //返回数据
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("role", role);
        return InterfaceParamUtils.getOutData(LOGIN_SUCCESS.getStateCode(), LOGIN_SUCCESS.getStateMsg(), resultMap);
    }


    /**
     * 登录状态验证API
     * @param request
     * @return
     */
    @Path("/isLogged")
    @GET
    public String getSession(@Context HttpServletRequest request) {
        String userName = null;
        String role = null;
        try {
            userName = request.getSession().getAttribute("userName").toString();
            role = request.getSession().getAttribute("role").toString();
        } catch (Exception e) {
            log.debug("未获取到用户Session");
            return InterfaceParamUtils.getOutData(USER_IS_NOT_LOGIN.getStateCode(), USER_IS_NOT_LOGIN.getStateMsg(), null);
        }
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("userName", userName);
        resultMap.put("role", role);
        return InterfaceParamUtils.getOutData(USER_IS_LOINGED.getStateCode(), USER_IS_LOINGED.getStateMsg(), resultMap);
    }

    /**
     * 注销API
     * @param request
     * @return
     */
    @Path("/loginOut")
    @GET
    public String loginOut(@Context HttpServletRequest request) {
        request.getSession().invalidate();
        return InterfaceParamUtils.getOutData(LOGINOUT_SUCCESS.getStateCode(), LOGINOUT_SUCCESS.getStateMsg(),null);
    }
}
