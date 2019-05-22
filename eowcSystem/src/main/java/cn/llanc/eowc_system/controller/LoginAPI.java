package cn.llanc.eowc_system.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.llanc.eowc_system.common.InterfaceParamUtils;
import cn.llanc.eowc_system.domain.WebUser;
import cn.llanc.eowc_system.service.ILoginService;
import cn.llanc.eowc_system.service.IUserManagerService;
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
    private ILoginService loginService;
    @Autowired
    private IUserManagerService userManagerService;

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
            return InterfaceParamUtils.getOutData(LOGIN_ERROR, null);
        }
        if (null == userName || "" == userName || null == password || "" == password) {
            return InterfaceParamUtils.getOutData(LOGIN_ERROR, null);
        }
        log.debug("用户名密码校验");
        String role = loginService.loginVerification(userName, password);
        if (LOGIN_ERROR.getStateCode().equals(role)) {
            return InterfaceParamUtils.getOutData(LOGIN_ERROR, null);
        }
        log.debug("用户名密码校验通过");
        if (userName.length() == 11) {
            //手机号登录，获取用户名
            WebUser user = userManagerService.getUserByPhone(userName);
            userName = user.getUName();
        }
        log.debug("设置Session");
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);
        session.setAttribute("role", role);

        //返回数据
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("role", role);
        return InterfaceParamUtils.getOutData(LOGIN_SUCCESS, resultMap);
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
            return InterfaceParamUtils.getOutData(USER_IS_NOT_LOGIN, null);
        }
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("userName", userName);
        resultMap.put("role", role);
        return InterfaceParamUtils.getOutData(USER_IS_LOINGED, resultMap);
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
        return InterfaceParamUtils.getOutData(LOGINOUT_SUCCESS,null);
    }

    /**
     * 获取验证码
     * @param inparam
     * @param request
     * @return
     */
    @Path("/verificationCode")
    @POST
    public String getVerificationCode(Map inparam,@Context HttpServletRequest request) {
        log.debug("入参校验");
        String phone = null;
        try {
            phone = inparam.get("phone").toString();
        } catch (Exception e) {
            log.debug("获取手机号失败", e);
            return InterfaceParamUtils.getOutData(SEND_SMS_ERROR, null);
        }
        //此处可以添加手机号码请求频次校验

        log.debug("发送验证码");
        String code = loginService.sendCode(phone);
        if (SEND_SMS_ERROR.getStateCode().equals(code)) {
            return InterfaceParamUtils.getOutData(SEND_SMS_ERROR, null);
        }
        if (THIS_PHONE_NO_USRE.getStateCode().equals(code)) {
            return InterfaceParamUtils.getOutData(THIS_PHONE_NO_USRE, null);
        }
        //验证码放入session
        HttpSession session = request.getSession();
        session.setAttribute("verificationCode", code);
        session.setMaxInactiveInterval(180000);
        return InterfaceParamUtils.getOutData(SEND_SMS_SUCCESS, null);
    }

    /**
     * @param inparam
     * @param request
     * @return
     */
    @Path("/chanPwdByPhone")
    @PUT
    public String findPwd(Map inparam,@Context HttpServletRequest request) {
        log.debug("入参校验");
        String phone = "";
        String code = "";
        String pwd = "";
        try {
            phone = inparam.get("phone").toString();
            code = inparam.get("code").toString();
            pwd = inparam.get("pwd").toString();
        } catch (Exception e) {
            log.debug("获取信息失败", e);
            return InterfaceParamUtils.getOutData(GET_DATA_ERROR, null);
        }

        //获取session中的验证码
        String sessionCode = "";
        try {
            sessionCode = request.getSession().getAttribute("verificationCode").toString();
            System.out.println(sessionCode);
        } catch (Exception e) {
            log.debug("未获取待服务器端验证码",e);
            return InterfaceParamUtils.getOutData(CODE_VERIFY_ERROR, null);
        }

        if (sessionCode.equals(code)) {
            //验证通过
            String result = userManagerService.changeUserPwdByPhone(phone, pwd);
            if (FIND_PASSWORD_SUCCESS.getStateCode().equals(result)) {
                return InterfaceParamUtils.getOutData(FIND_PASSWORD_SUCCESS, null);
            } else {
                return InterfaceParamUtils.getOutData(FIND_PASSWORD_ERROR, null);
            }
        }else {
            return InterfaceParamUtils.getOutData(CODE_VERIFY_ERROR, null);
        }

    }
}
