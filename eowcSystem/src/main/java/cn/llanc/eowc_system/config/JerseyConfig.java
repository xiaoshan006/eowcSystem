package cn.llanc.eowc_system.config;

import cn.llanc.eowc_system.controller.FileUploadAPI;
import cn.llanc.eowc_system.controller.FrontDeskSettingAPI;
import cn.llanc.eowc_system.controller.LoginAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * @author liulc
 * @ClassName JerseyConfig
 * @Description TODO
 * @date 2019/05/16
 **/
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(LoginAPI.class);
        register(FrontDeskSettingAPI.class);
        register(FileUploadAPI.class);
    }
}
