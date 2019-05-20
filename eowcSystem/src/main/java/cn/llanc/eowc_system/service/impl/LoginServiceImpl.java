package cn.llanc.eowc_system.service.impl;

import cn.llanc.eowc_system.common.InterfaceParamUtils;
import cn.llanc.eowc_system.common.MD5Utils;
import cn.llanc.eowc_system.common.SMSUtils;
import cn.llanc.eowc_system.domain.WebUser;
import cn.llanc.eowc_system.mapper.WebUserMapper;
import cn.llanc.eowc_system.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.llanc.eowc_system.common.SystemConsts.LOGIN_ERROR;
import static cn.llanc.eowc_system.common.SystemConsts.THIS_PHONE_NO_USRE;

/**
 * @author liulc
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @date 2019/05/16
 **/
@Transactional
@Service("ILoginService")
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private WebUserMapper webUserMapper;

    /**
     * 登录校验服务
     * @param userName
     * @param password
     * @return 角色
     */
    @Override
    public String loginVerification(String userName, String password) {
        String dbPd = webUserMapper.findUPasswordByUName(userName);
        if (null == dbPd) {
            //尝试手机号登录
            WebUser user = webUserMapper.selectByUMobilePhone(userName);
            if (null == user) {
                return LOGIN_ERROR.getStateCode();
            }
            //获取密码
            dbPd = user.getUPassword();
            userName = user.getUName();
        }
        String md5Pwd =dbPd;
        boolean verify = MD5Utils.verify(password,md5Pwd);
        if (!verify) {
            return LOGIN_ERROR.getStateCode();
        }

        Integer role = webUserMapper.findURoleByUNameAndUPassword(userName, md5Pwd);
        return role.toString();
    }


    /**
     * 发送验证码
     * @param inparam 手机号
     * @return
     */
    @Override
    public String sendCode(String inparam) {

        WebUser user = webUserMapper.selectByUMobilePhone(inparam);
        if (null == user) {
            return InterfaceParamUtils.getOutData(THIS_PHONE_NO_USRE, null);
        }
        String code = SMSUtils.sendSms(inparam);
        return code;

    }
}
