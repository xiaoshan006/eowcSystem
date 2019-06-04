package cn.llanc.eowc_system.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import cn.llanc.eowc_system.domain.BannerImageInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BannerImageInfoMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(BannerImageInfo record);

    int insertSelective(BannerImageInfo record);

    BannerImageInfo selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(BannerImageInfo record);

    int updateByPrimaryKey(BannerImageInfo record);

    List<BannerImageInfo> findAll();


}