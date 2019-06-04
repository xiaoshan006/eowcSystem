package cn.llanc.eowc_system.controller.back_end.tableManager;

import cn.llanc.eowc_system.common.InterfaceParamUtils;
import cn.llanc.eowc_system.domain.WebUser;
import cn.llanc.eowc_system.service.IUserManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.llanc.eowc_system.common.SystemConsts.*;

/**
 * @author liulc
 * @ClassName UserManagerAPI
 * @Description 用户信息管理API
 * @date 2019/05/21
 **/
@Slf4j
@Component
@Path("/userTable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserManagerAPI {
    @Autowired
    IUserManagerService userManagerService;

    @Path("/userInfo")
    @GET
    public String getAllUserInfo() {
        List<WebUser> allUserInfo = userManagerService.getAllUserInfo();
        if (0 == allUserInfo.size()) {
            return InterfaceParamUtils.getOutData(GET_ALL_USER_INFO_ERROR, null);
        }
        Map<String, List<WebUser>> listMap = new HashMap<>();
        listMap.put("tableData", allUserInfo);
        return InterfaceParamUtils.getOutData(GET_ALL_USER_INFO_SUCCESS, listMap);
    }

    @Path("/userInfo")
    @POST
    public String addNewUser(Map inParam) {
        log.debug("入参校验");
        if (inParam != null) {
            String result = userManagerService.addNewUser(inParam);

            if (ADD_OR_UPDATA_USER_ERROR_PHONE_REPEAT.getStateCode().equals(result)) {
                return InterfaceParamUtils.getOutData(ADD_OR_UPDATA_USER_ERROR_PHONE_REPEAT, null);
            }
            if (ADD_OR_UPDATA_USER_ERROR_USERNAME_REPEAT.getStateCode().equals(result)) {
                return InterfaceParamUtils.getOutData(ADD_OR_UPDATA_USER_ERROR_USERNAME_REPEAT, null);
            }

            if (ADD_NEW_USER_SUCCESS.getStateCode().equals(result)) {
                return InterfaceParamUtils.getOutData(ADD_NEW_USER_SUCCESS, null);
            }
        }
        return InterfaceParamUtils.getOutData(ADD_NEW_USER_ERROR, null);
    }

    @Path("/userInfo")
    @PUT
    public String updateUser(Map inParam) {
        log.debug("入参校验");
        if (inParam != null) {
            String result = userManagerService.updateUser(inParam);
            if (ADD_OR_UPDATA_USER_ERROR_PHONE_REPEAT.getStateCode().equals(result)) {
                return InterfaceParamUtils.getOutData(ADD_OR_UPDATA_USER_ERROR_PHONE_REPEAT, null);
            }
            if (ADD_OR_UPDATA_USER_ERROR_USERNAME_REPEAT.getStateCode().equals(result)) {
                return InterfaceParamUtils.getOutData(ADD_OR_UPDATA_USER_ERROR_USERNAME_REPEAT, null);
            }
            if (UPDATA_USER_INFO_SUCCESS.getStateCode().equals(result)) {
                return InterfaceParamUtils.getOutData(UPDATA_USER_INFO_SUCCESS, null);
            }
        }
        return InterfaceParamUtils.getOutData(UPDATA_USER_INFO_ERROR, null);
    }

    @Path("/userInfo")
    @DELETE
    public String deleteUser(Map inParam) {
        log.debug("入参校验");
        if (inParam != null) {
            List<String> ids= (List<String>) inParam.get("ids");
            String result = userManagerService.deleteUser(ids);
            if (DELETE_USER_SUCCESS.getStateCode().equals(result)) {
                return InterfaceParamUtils.getOutData(DELETE_USER_SUCCESS, null);
            }
        }
        return InterfaceParamUtils.getOutData(DELETE_USER_ERROR, null);
    }


}
