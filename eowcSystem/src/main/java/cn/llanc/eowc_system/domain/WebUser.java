package cn.llanc.eowc_system.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WebUser implements Serializable {
    /**
    * 用户Id，主键u_id
    */
    private Integer uId;

    /**
    * 登录用户名
    */
    private String uName;

    /**
    * 登录密码，加盐md5
    */
    private String uPassword;

    /**
    * 用户角色：0 管理员，1 操作员
    */
    private Integer uRole;

    private static final long serialVersionUID = 1L;
}