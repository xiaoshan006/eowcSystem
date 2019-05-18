package cn.llanc.eowc_system.common;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

/**
 * @author liulc
 * @ClassName InterfaceParamUtils
 * @Description TODO
 * @date 2019/05/16
 **/
public class InterfaceParamUtils {
    /**
     * 出参
     * @param stateCode 状态码
     * @param stateMsg 状态信息
     * @param resultMap
     * @return
     */
    public static String getOutData(String stateCode, String stateMsg, Map resultMap) {
        Map<String, Object> outData = new HashMap<>();
        outData.put("stateCode", stateCode);
        outData.put("stateMsg", stateMsg);
        outData.put("result", resultMap);
        return JSONObject.toJSONString(outData,WriteMapNullValue);
    }

    /**
     * 出参(重载)
     * @param systemCode 枚举
     * @param resultMap
     * @return
     */
    public static String getOutData(SystemConsts systemCode, Map resultMap) {
        Map<String, Object> outData = new HashMap<>();
        outData.put("stateCode", systemCode.getStateCode());
        outData.put("stateMsg", systemCode.getStateMsg());
        outData.put("result", resultMap);
        return JSONObject.toJSONString(outData,WriteMapNullValue);
    }

}
