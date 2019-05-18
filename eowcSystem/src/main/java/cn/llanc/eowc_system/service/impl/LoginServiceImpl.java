package cn.llanc.eowc_system.service.impl;

import cn.llanc.eowc_system.common.MD5Utils;
import cn.llanc.eowc_system.mapper.WebUserMapper;
import cn.llanc.eowc_system.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cn.llanc.eowc_system.common.SystemConsts.LOGIN_ERROR;

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
        List<String> userList = webUserMapper.findUPasswordByUName(userName);
        if (0 == userList.size()) {
            return LOGIN_ERROR.getStateCode();
        }
        String md5Pwd =userList.get(0);
        boolean verify = MD5Utils.verify(password,md5Pwd);
        if (!verify) {
            return LOGIN_ERROR.getStateCode();
        }
        Integer role = webUserMapper.findURoleByUNameAndUPassword(userName, md5Pwd).get(0);
        return role.toString();
    }
}
