package cn.llanc.eowc_system.service;

import cn.llanc.eowc_system.domain.WebUser;

/**
 * @author liulc
 * @ClassName IUserManagerService
 * @Description TODO
 * @date 2019/05/20
 **/
public interface IUserManagerService {


    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    WebUser getUserByPhone(String phone);

    /**
     * 根据手机号修改用户密码
     * @param phone
     * @return
     */
    String changeUserPwdByPhone(String phone,String pwd);

}
