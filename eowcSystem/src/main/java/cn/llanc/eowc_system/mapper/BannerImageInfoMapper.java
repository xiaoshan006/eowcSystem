package cn.llanc.eowc_system.mapper;

import cn.llanc.eowc_system.domain.BannerImageInfo;

public interface BannerImageInfoMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(BannerImageInfo record);

    int insertSelective(BannerImageInfo record);

    BannerImageInfo selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(BannerImageInfo record);

    int updateByPrimaryKey(BannerImageInfo record);
}