package cn.llanc.eowc_system.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BannerImageInfo implements Serializable {
    /**
    * 轮播图Id,主键
    */
    private Integer bId;

    /**
    * 图片地址
    */
    private String bSrc;

    /**
    * 图片标题
    */
    private String bTitle;

    /**
    * 图片描述
    */
    private String bDesc;

    private static final long serialVersionUID = 1L;
}