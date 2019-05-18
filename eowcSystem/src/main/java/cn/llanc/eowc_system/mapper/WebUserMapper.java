package cn.llanc.eowc_system.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import cn.llanc.eowc_system.domain.WebUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WebUserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(WebUser record);

    int insertSelective(WebUser record);

    WebUser selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(WebUser record);

    int updateByPrimaryKey(WebUser record);

    List<String> findUPasswordByUName(@Param("uName")String uName);

    List<WebUser> findByAll(WebUser webUser);

	List<Integer> findURoleByUNameAndUPassword(@Param("uName")String uName,@Param("uPassword")String uPassword);






}