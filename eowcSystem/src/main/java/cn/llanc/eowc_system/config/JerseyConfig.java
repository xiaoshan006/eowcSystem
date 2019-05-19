package cn.llanc.eowc_system.config;

import cn.llanc.eowc_system.controller.FileUploadAPI;
import cn.llanc.eowc_system.controller.FrontDeskSettingAPI;
import cn.llanc.eowc_system.controller.LoginAPI;
import cn.llanc.eowc_system.controller.front_end.HomeAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * @author liulc
 * @ClassName JerseyConfig
 * @Description jersey配置类
 * @date 2019/05/16
 **/
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(LoginAPI.class);
        register(FrontDeskSettingAPI.class);
        register(FileUploadAPI.class);
        register(HomeAPI.class);
    }
}
