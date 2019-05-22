package cn.llanc.eowc_system.service;

import cn.llanc.eowc_system.common.SystemConsts;
import cn.llanc.eowc_system.domain.WebUser;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取所有用户信息
     * @return
     */
    List<WebUser> getAllUserInfo();

    /**
     * 添加新用户
     * @param inparam
     * @return
     */
    String addNewUser(Map inparam);

    /**
     * 更新用户信息
     * @param inparam
     * @return
     */
    String updateUser(Map inparam);

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    String deleteUser(List<String> ids);

    /**
     * 校验用户名和手机号
     * @param uMobilePhone
     * @param uName
     * @param isAdd 是否为新增操作
     * @param id
     * @return
     */
    public SystemConsts havePhoneOrName(String uMobilePhone, String uName, Boolean isAdd, Integer id);

}

