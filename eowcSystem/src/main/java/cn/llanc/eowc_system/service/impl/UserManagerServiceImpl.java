package cn.llanc.eowc_system.service.impl;

import cn.llanc.eowc_system.common.MD5Utils;
import cn.llanc.eowc_system.domain.WebUser;
import cn.llanc.eowc_system.mapper.WebUserMapper;
import cn.llanc.eowc_system.service.IUserManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.llanc.eowc_system.common.SystemConsts.*;

/**
 * @author liulc
 * @ClassName UserManagerServiceImpl
 * @Description TODO
 * @date 2019/05/20
 **/
@Slf4j
@Service("IUserManagerService")
@Transactional
public class UserManagerServiceImpl implements IUserManagerService {
    @Autowired
    private WebUserMapper webUserMapper;


    /**
     * 根据手机号获取用户
     *
     * @param phone
     * @return
     */
    @Override
    public WebUser getUserByPhone(String phone) {
        WebUser user;
        user = webUserMapper.selectByUMobilePhone(phone);
        return user;
    }

    /**
     * 修改密码
     *
     * @param phone 手机号
     * @return
     */
    @Override
    public String changeUserPwdByPhone(String phone, String pwd) {
        WebUser user = getUserByPhone(phone);
        if (null == user) {
            return THIS_PHONE_NO_USRE.getStateCode();
        }
        String md5Pwd = MD5Utils.generate(pwd);

        System.out.println(user.getUPassword());
        user.setUPassword(md5Pwd);
        System.out.println(user.getUPassword());

        int count = 0;
        try {
            count = webUserMapper.updateByPrimaryKeySelective(user);
            if (count == 1) {
                return FIND_PASSWORD_SUCCESS.getStateCode();
            }else {
                return CHANGE_PASSWORD_ERROR.getStateCode();
            }
        } catch (Exception e) {
            log.debug("更新下数据失败", e);
            return CHANGE_PASSWORD_ERROR.getStateCode();
        }
    }
}
