package cn.llanc.eowc_system.service.impl;

import cn.llanc.eowc_system.bo.CommonFooterOutBO;
import cn.llanc.eowc_system.bo.CommonHeaderOutBO;
import cn.llanc.eowc_system.common.MapEntityConvert;
import cn.llanc.eowc_system.mapper.CommonInfoMapper;
import cn.llanc.eowc_system.service.ICommonInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liulc
 * @ClassName CommonInfoServiceImpl
 * @Description TODO
 * @date 2019/05/19
 **/
@Service("ICommonInfoService")
@Transactional
@Slf4j
public class CommonInfoServiceImpl implements ICommonInfoService {

    @Autowired
    CommonInfoMapper commonInfoMapper;

    /**
     * 获取前台头部信息
     * @return
     */
    @Override
    public Map getHeaderInfo() {
        CommonHeaderOutBO headerInfo = commonInfoMapper.findCBarShowAndCHeaderTextAndCHeardLogoAndCQqHrefAndCWinxinSrcByCId("1");
        Map<String, Object> headerInfoMap = MapEntityConvert.objectToMap(headerInfo);
        return headerInfoMap;
    }

    /**
     * 获取前台页脚信息
     * @return
     */
    @Override
    public Map getFooterInfo() {
        CommonFooterOutBO footerInfo =
                commonInfoMapper.findCFooterLogoAndCFooterTextAndCAddressAndCTelephoneAndCMobilePhoneAndCEmailAndCCompanyNameByCId("1");
        Map<String, Object> footerInfoMap = MapEntityConvert.objectToMap(footerInfo);
        return footerInfoMap;
    }

    /**
     * 获取后台公共信息
     * @return
     */
    @Override
    public Map getBackCommonInfo() {
        CommonFooterOutBO footerInfo =
                commonInfoMapper.findCFooterLogoAndCFooterTextAndCAddressAndCTelephoneAndCMobilePhoneAndCEmailAndCCompanyNameByCId("1");
        Map<String, Object> companyName = new HashMap<>();
        companyName.put("cConpanyName", footerInfo.getCCompanyName());
        return companyName;
    }
}
