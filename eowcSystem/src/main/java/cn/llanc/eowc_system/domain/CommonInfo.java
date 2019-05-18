package cn.llanc.eowc_system.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonInfo implements Serializable {
    /**
     * 公共部分Id，主键
     */
    private String cId;

    /**
     * 头部Bar： 1显示，2不显示
     */
    private String cBarShow;

    /**
     * 头部左上角文字
     */
    private String cHeaderText;

    /**
     * qq在线状态链接
     */
    private String cQqHref;

    /**
     * 微信图片地址
     */
    private String cWinxinSrc;

    /**
     * 头部logo地址
     */
    private String cHeardLogo;

    /**
     * 页脚logo地址
     */
    private String cFooterLogo;

    /**
     * 公司地址
     */
    private String cAddress;

    /**
     * 公司固定电话
     */
    private String cTelephone;

    /**
     * 公司移动电话
     */
    private String cMobilePhone;

    /**
     * 公司电子邮箱
     */
    private String cEmail;

    /**
     * 公司全称
     */
    private String cCompanyName;

    /**
     * 页脚文字
     */
    private String cFooterText;

    private static final long serialVersionUID = 1L;
}