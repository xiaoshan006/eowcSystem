package cn.llanc.eowc_system.mapper;

import cn.llanc.eowc_system.domain.HomePageConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomePageConfigMapper {
    int deleteByPrimaryKey(Integer hId);

    int insert(HomePageConfig record);

    int insertSelective(HomePageConfig record);

    HomePageConfig selectByPrimaryKey(Integer hId);

    int updateByPrimaryKeySelective(HomePageConfig record);

    int updateByPrimaryKey(HomePageConfig record);
}