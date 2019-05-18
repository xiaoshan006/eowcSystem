package cn.llanc.eowc_system.common;

import lombok.Getter;

/**
 * @author liulc
 * @ClassName SystemConsts
 * @Description TODO
 * @date 2019/05/16
 **/
@Getter
public enum SystemConsts {

    /**
     * 登录状态码
     */
    LOGIN_SUCCESS("2001","登录成功"),
    LOGIN_ERROR("5001","登录失败"),
    USER_IS_LOINGED("2002","用户已登录"),
    USER_IS_NOT_LOGIN("4011","用户未登录"),
    LOGINOUT_SUCCESS("2003", "注销成功"),

    /**
     * 首页设置状态码
     */
    SHOW_INFO_SUCCESS("2004","数据回显成功"),

    /**
     * 文件上传
     */
    FILE_UPLOAD_SUCCESS("2005", "文件上传成功"),
    FILE_UPLOAD_ERROR("5002", "文件上传失败"),
    ;
    String stateCode;
    String stateMsg;

    SystemConsts(String stateCode, String stateMsg) {
        this.stateCode = stateCode;
        this.stateMsg = stateMsg;
    }
}
