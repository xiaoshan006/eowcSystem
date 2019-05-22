package cn.llanc.eowc_system.service.impl;

import cn.llanc.eowc_system.common.MD5Utils;
import cn.llanc.eowc_system.common.SystemConsts;
import cn.llanc.eowc_system.domain.WebUser;
import cn.llanc.eowc_system.mapper.WebUserMapper;
import cn.llanc.eowc_system.service.IUserManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            } else {
                return CHANGE_PASSWORD_ERROR.getStateCode();
            }
        } catch (Exception e) {
            log.debug("更新下数据失败", e);
            return CHANGE_PASSWORD_ERROR.getStateCode();
        }
    }

    /**
     * 获取所有用户信息
     *
     * @return
     */
    @Override
    public List<WebUser> getAllUserInfo() {
        List<WebUser> users = webUserMapper.selectAll();
        return users;
    }

    /**
     * 添加新用户
     *
     * @param inparam
     * @return
     */
    @Override
    public String addNewUser(Map inparam) {
        String uName = inparam.get("uName").toString();
        String uRole = inparam.get("uRole").toString();
        String uMobilePhone = inparam.get("uMobilePhone").toString();
        String uPassword = inparam.get("uPassword").toString();

        //校验手机号和用户名
        SystemConsts systemConsts = havePhoneOrName(uMobilePhone, uName,true,null);
        if (!ADD_OR_UPDATA_USER_PHONE_OR_USERNAME_NO_REPEAT.getStateCode().equals(systemConsts.getStateCode())) {
            return systemConsts.getStateCode();
        }

        WebUser user = new WebUser();
        user.setUName(uName);
        user.setURole(Integer.parseInt(uRole));
        user.setUPassword(MD5Utils.generate(uPassword));
        user.setUMobilePhone(uMobilePhone);
        int count = webUserMapper.insertSelective(user);
        if (1 == count) {
            return ADD_NEW_USER_SUCCESS.getStateCode();
        }
        return ADD_NEW_USER_ERROR.getStateCode();
    }

    /**
     * 更新用户信息
     *
     * @param inparam
     * @return
     */
    @Override
    public String updateUser(Map inparam) {
        String uName = inparam.get("uName").toString();
        int uRole = Integer.parseInt(inparam.get("uRole").toString());
        String uMobilePhone = inparam.get("uMobilePhone").toString();
        int uId = Integer.parseInt(inparam.get("uId").toString());

        //校验手机号和用户名
        SystemConsts systemConsts = havePhoneOrName(uMobilePhone, uName, false,uId);
        if (!ADD_OR_UPDATA_USER_PHONE_OR_USERNAME_NO_REPEAT.getStateCode().equals(systemConsts.getStateCode())) {
            return systemConsts.getStateCode();
        }

        WebUser user = new WebUser();
        user.setUName(uName);
        user.setURole(uRole);
        user.setUMobilePhone(uMobilePhone);
        user.setUId(uId);

        int count = webUserMapper.updateByPrimaryKeySelective(user);

        if (1 == count) {
            return UPDATA_USER_INFO_SUCCESS.getStateCode();
        }
        return UPDATA_USER_INFO_ERROR.getStateCode();
    }

    /**
     * 批量删除用户
     *
     * @param ids
     * @return
     */
    @Override
    public String deleteUser(List<String> ids) {
        List<Integer> idsInt = ids.stream().map(Integer::parseInt).collect(Collectors.toList());
        int count = webUserMapper.deleteByUIdIn(idsInt);
        if (0 >= count) {
            return DELETE_USER_ERROR.getStateCode();
        }
        return DELETE_USER_SUCCESS.getStateCode();
    }

    /**
     * 校验用户名和手机号
     *
     * @param uMobilePhone
     * @param uName
     * @param isAdd
     * @param id
     * @return
     */
    public SystemConsts havePhoneOrName(String uMobilePhone, String uName, Boolean isAdd, Integer id) {
        WebUser byUMobilePhone = webUserMapper.findByUMobilePhone(uMobilePhone);
        WebUser byUName = webUserMapper.findByUName(uName);
        if (byUMobilePhone != null) {
            if (isAdd) {
                //当前手机号有记录且操作为新增，不允许插入
                return ADD_OR_UPDATA_USER_ERROR_PHONE_REPEAT;
            } else if (byUMobilePhone.getUId() != id) {
                //当前手机号有记录且操作是更新，判断id,如果ID相同则允许操作，不同则禁止
                return ADD_OR_UPDATA_USER_ERROR_PHONE_REPEAT;
            }
        }
        if (byUName != null) {
            if (isAdd) {
                //当前用户名有记录且操作为新增，不允许插入
                return ADD_OR_UPDATA_USER_ERROR_USERNAME_REPEAT;
            } else if (byUMobilePhone.getUId() != id) {
                //当前用户名有记录且操作为更新，判断id,如果ID相同则允许操作，不同则禁止
                return ADD_OR_UPDATA_USER_ERROR_USERNAME_REPEAT;
            }
        }
        return ADD_OR_UPDATA_USER_PHONE_OR_USERNAME_NO_REPEAT;
    }

}
