package cn.llanc.eowc_system.service.impl;

import cn.llanc.eowc_system.common.MapEntityConvert;
import cn.llanc.eowc_system.domain.CommonInfo;
import cn.llanc.eowc_system.mapper.CommonInfoMapper;
import cn.llanc.eowc_system.service.IFrontDeskSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static cn.llanc.eowc_system.common.SystemConsts.UPDATE_INFO_ERROR;
import static cn.llanc.eowc_system.common.SystemConsts.UPDATE_INFO_SUCCESS;

/**
 * @author liulc
 * @ClassName FrontDeskSettingServiceImpl
 * @Description 前台设置服务
 * @date 2019/05/17
 **/
@Transactional
@Slf4j
@Service("IFrontDeskSettingService")
public class FrontDeskSettingServiceImpl implements IFrontDeskSettingService {

    @Autowired
    CommonInfoMapper commonInfoMapper;

    /**
     * 更新信息
     * @param inparam
     * @return
     */
    @Override
    public String updateInfos(Map inparam) {
        //入参转对象
        CommonInfo newInfo = null;
        try {
            newInfo = (CommonInfo) MapEntityConvert.mapToObject(inparam, CommonInfo.class);
        } catch (Exception e) {
            log.debug("对象转换异常",e);
            return UPDATE_INFO_ERROR.getStateCode();
        }
        //设置主键
        newInfo.setCId("1");
        int count = commonInfoMapper.updateByPrimaryKeySelective(newInfo);
        if (1 == count) {
            return UPDATE_INFO_SUCCESS.getStateCode();
        }
        return UPDATE_INFO_ERROR.getStateCode();
    }


    /**
     * 数据回显
     *
     * @return
     */
    @Override
    public Map showInfos() {
        CommonInfo commonInfo = commonInfoMapper.selectByPrimaryKey("1");
        Map<String, Object> resultMap = MapEntityConvert.objectToMap(commonInfo);
        return resultMap;
    }


}
