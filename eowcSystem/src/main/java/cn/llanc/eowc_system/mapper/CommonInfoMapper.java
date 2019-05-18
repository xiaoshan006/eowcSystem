package cn.llanc.eowc_system.mapper;

import cn.llanc.eowc_system.domain.CommonInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonInfoMapper {
    int deleteByPrimaryKey(String cId);

    int insert(CommonInfo record);

    int insertSelective(CommonInfo record);

    CommonInfo selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(CommonInfo record);

    int updateByPrimaryKey(CommonInfo record);
}