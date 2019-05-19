package cn.llanc.eowc_system.controller;

import cn.llanc.eowc_system.common.InterfaceParamUtils;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static cn.llanc.eowc_system.common.SystemConsts.GET_FILE_UPLOAD_TOKEN_ERROR;
import static cn.llanc.eowc_system.common.SystemConsts.GET_FILE_UPLOAD_TOKEN_SUCCESS;

/**
 * @author liulc
 * @ClassName FileUploadAPI
 * @Description TODO
 * @date 2019/05/18
 **/
@Slf4j
@Component
@Path("/fileUpload")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FileUploadAPI {

    private static final String accessKey = "5eoVeFNjB8cBPEarqdIRR5dJlI7UEk2oGNgyXCtK";    //访问秘钥
    private static final String secretKey = "jgqC8ngWdMj7UveD8HOBhPnAO8jDcxWDtwPydp6S";    //授权秘钥
    private static final String bucket = "graduationproject";       //存储空间名称
    private static final String domain = "prn5kvu34.bkt.clouddn.com";       //外链域名

    /**
     * 七牛云上传生成凭证
     *
     * @throws Exception
     */
    @Path("/qiniuUpToken")
    @POST
    public String qiniuUpToken(Map inParam) {
        String suffix = null;
        try {
            suffix = inParam.get("suffix").toString();
        } catch (Exception e) {
            return InterfaceParamUtils.getOutData(GET_FILE_UPLOAD_TOKEN_ERROR,null);
        }

        Map<String, Object> result = new HashMap<String, Object>();
        try {
            //验证七牛云身份是否通过
            Auth auth = Auth.create(accessKey, secretKey);
            //生成凭证
            String upToken = auth.uploadToken(bucket);
            result.put("token", upToken);
            //存入外链默认域名，用于拼接完整的资源外链路径
            result.put("domain", domain);

            // 是否可以上传的图片格式
            /*boolean flag = false;
            String[] imgTypes = new String[]{"jpg","jpeg","bmp","gif","png"};
            for(String fileSuffix : imgTypes) {
                if(suffix.substring(suffix.lastIndexOf(".") + 1).equalsIgnoreCase(fileSuffix)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                throw new Exception("图片：" + suffix + " 上传格式不对！");
            }*/

            //生成实际路径名
            String randomFileName = UUID.randomUUID().toString() + suffix;
            result.put("fileUrl", randomFileName);
            return InterfaceParamUtils.getOutData(GET_FILE_UPLOAD_TOKEN_SUCCESS, result);
        } catch (Exception e) {
            return InterfaceParamUtils.getOutData(GET_FILE_UPLOAD_TOKEN_ERROR, null);
        }
    }


}
