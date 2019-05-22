package cn.llanc.eowc_system.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HomePageConfig implements Serializable {
    /**
    * 主键
    */
    private Integer hId;

    /**
    * 首页供应商显示状态: 1显示，2不显示
    */
    private String hClientDiv;

    /**
    * 首页服务显示状态
    */
    private String hServiceDiv;

    /**
    * 首页关于我们状态
    */
    private String hAboutUsDiv;

    /**
    * 首页人才队伍状态
    */
    private String hTalentDiv;

    /**
    * 首页客户评价状态
    */
    private String hEvaluateDiv;

    /**
    * 首页核心产品展示状态
    */
    private String hProductDiv;

    private static final long serialVersionUID = 1L;
}