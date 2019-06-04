package cn.llanc.eowc_system.common;

import lombok.Getter;

import javax.ws.rs.GET;

/**
 * @author liulc
 **/
@Getter
public enum SystemConsts {

    /**
     * 权限状态码
     */
    UER_NOT_EXIST_OR_NO_PERMISSION("401", "权限不足"),

    /**
     * 登录状态码
     */
    LOGIN_SUCCESS("2001", "登录成功"),
    LOGIN_ERROR("5001", "登录失败"),
    USER_IS_LOINGED("2002", "用户已登录"),
    USER_IS_NOT_LOGIN("4011", "用户未登录"),
    LOGINOUT_SUCCESS("2003", "注销成功"),

    /**
     * 首页设置状态码
     */
    SHOW_INFO_SUCCESS("2004", "数据回显成功"),
    UPDATE_INFO_SUCCESS("2006", "数据保存成功！"),
    UPDATE_INFO_ERROR("5003", "数据保存失败，请稍后再试！"),

    /**
     * 文件上传
     */
    GET_FILE_UPLOAD_TOKEN_SUCCESS("2005", "获取上传TOKEN成功"),
    GET_FILE_UPLOAD_TOKEN_ERROR("5002", "获取上传TOKEN失败"),

    /**
     * 信息获取
     */
    GET_INFORMATION_SUCCESS("2005", "数据获取成功"),
    GET_INFORMATION_ERROR("5004", "数据获取失败"),

    /**
     * 找回密码
     */
    FIND_PASSWORD_SUCCESS("2006", "找回密码成功，请用新密码登录!"),
    THIS_PHONE_NO_USRE("5005", "当前手机号无用户"),
    FIND_PASSWORD_ERROR("5006", "找回密码失败"),
    SEND_SMS_ERROR("5007", "获取验证码失败，请稍后再试"),
    SEND_SMS_FREQUENT("5008", "获取验证码过于频繁！"),
    SEND_SMS_SUCCESS("2007", "验证码发送成功，三分钟内有效!"),
    CODE_VERIFY_SUCCESS("2008", "验证码校验通过"),
    CODE_VERIFY_ERROR("5009", "验证码错误！"),
    CHANGE_PASSWORD_ERROR("50010", "修改密码失败，请稍后再试！"),
    GET_DATA_ERROR("50011", "获取数据失败!"),

    /**
     * 用户信息管理
     */
    GET_ALL_USER_INFO_SUCCESS("2009", "获取用户信息成功！"),
    GET_ALL_USER_INFO_ERROR("50012", "获取用户信息失败！"),
    ADD_NEW_USER_SUCCESS("2010", "添加新用户成功!"),
    ADD_NEW_USER_ERROR("50013", "添加新用户失败！"),
    UPDATA_USER_INFO_SUCCESS("2011", "更用户成功成功！"),
    UPDATA_USER_INFO_ERROR("50014", "更用户信息失败！"),
    ADD_OR_UPDATA_USER_ERROR_PHONE_REPEAT("50015", "该手机号已存在！"),
    ADD_OR_UPDATA_USER_ERROR_USERNAME_REPEAT("50016", "该用户名已存在！"),
    ADD_OR_UPDATA_USER_PHONE_OR_USERNAME_NO_REPEAT("20013", "用户名和手机号均未占用！"),
    DELETE_USER_SUCCESS("20012", "删除用户成功！"),
    DELETE_USER_ERROR("50017", "删除用户失败！"),

    /**
     * 首页配置
     */
    UPDATE_HOME_PAGE_CONFIG_SUCCESS("20014","数据更新成功!"),
    UPDATE_HOME_PAGE_CONFIG_ERROR("50018","数据更新失败!"),
    SHOW_HOME_PAGE_CONFIG_SUCCESS("20015","首页配置信息获取成功!"),
    SHOW_HOME_PAGE_CONFIG_ERROR("50019","首页配置信息获取失败!"),

    /**
     * 首页轮播图，顶部和关于我们
     */
    UPDATE_BANNER_IMAGE_SUCCESS("20015","图片信息保存成功！"),
    UPDATE_BANNER_IMAGE_ERROR("50020","图片信息保存成功！"),
    SHOW_BANNER_INFO_SUCCESS("20016", "轮播图信息获取成功！"),
    SHOW_BANNER_INFO_ERROR("50021", "轮播图信息获取失败！"),

    /**
     * 首页供应商信息
     */
    SHOW_CLIENT_INFO_SUCCESS("20017","获取供应商信息成功！"),

    /**
     * 首页服务信息
     */
    SHOW_SERVICE_INFO_SUCCESS("20018", "获取服务信息成功！"),

    /**
     * 首页产品信息
     */
    SHOW_PRODUCT_INFO_SUCCESS("20019", "获取产品信息成功！"),

    /**
     * 首页评价信息
     */
    SHOW_EVALUATE_INFO_SUCCESS("20020", "获取评价信息成功！"),

    /**
     * 首页人才信息
     */
    SHOW_TALENT_INFO_SUCCESS("20021", "获取人才信息成功！"),

    /**
     * 首页关于信息
     */
    SHOW_ABOUT_INFO_SUCCESS("20022", "获取关于信息成功！"),


    ;
    /**
     * 状态码
     */
    String stateCode;
    /**
     * 状态信息
     */
    String stateMsg;
    SystemConsts(String stateCode, String stateMsg) {
        this.stateCode = stateCode;
        this.stateMsg = stateMsg;
    }
}
