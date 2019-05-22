package cn.llanc.eowc_system.mapper;
import java.util.Collection;

import cn.llanc.eowc_system.domain.WebUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface WebUserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(WebUser record);

    int insertSelective(WebUser record);

    WebUser selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(WebUser record);

    int updateByPrimaryKey(WebUser record);

    String findUPasswordByUName(@Param("uName") String uName);

    WebUser findByAll(WebUser webUser);

    Integer findURoleByUNameAndUPassword(@Param("uName") String uName, @Param("uPassword") String uPassword);

    WebUser selectByUMobilePhone(@Param("uMobilePhone")String uMobilePhone);

    List<WebUser> selectAll();

    int deleteByUIdIn(@Param("uIdCollection")Collection<Integer> uIdCollection);
    WebUser findByUName(@Param("uName")String uName);

	WebUser findByUMobilePhone(@Param("uMobilePhone")String uMobilePhone);








}