package cn.llanc.eowc_system.service;

/**
 * @author liulc
 * @ClassName ILoginService
 * @Description 登录接口
 * @date 2019/05/16
 **/

public interface ILoginService {

    /**
     * 用户名密码校验接口
     * @param userName
     * @param password
     * @return
     */
    String loginVerification(String userName, String password);
}
