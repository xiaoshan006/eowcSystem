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
    ;


    String stateCode;
    String stateMsg;

    SystemConsts(String stateCode, String stateMsg) {
        this.stateCode = stateCode;
        this.stateMsg = stateMsg;
    }
}
