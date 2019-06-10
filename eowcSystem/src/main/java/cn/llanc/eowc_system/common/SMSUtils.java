package cn.llanc.eowc_system.common;

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;

import static cn.llanc.eowc_system.common.SystemConsts.SEND_SMS_ERROR;

/**
 * @author liulc
 * @ClassName SMSUtils
 * @Description TODO
 * @date 2019/05/19
 **/
@Slf4j
public class SMSUtils {

    /**
     * 应用ID
     */
    private static int appid = 1400211060;

    /**
     * 密钥
     */
    private static String appkey = "XXX";

    /**
     * 模板ID
     */
    private static int templateId = 335032;


    public static String sendSms(String phone) {
        //随机码
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 1000));

        String[] params={code.toString(), "三"};


        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phone,
                    templateId, params, "", "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            log.debug("HTTP响应码错误", e);
            return SEND_SMS_ERROR.getStateCode();
        } catch (JSONException e) {
            log.debug("json解析错误", e);
            e.printStackTrace();
            return SEND_SMS_ERROR.getStateCode();
        } catch (IOException e) {
            log.debug("网络IO错误", e);
            e.printStackTrace();
            return SEND_SMS_ERROR.getStateCode();
        }
        return code;
    }


}
