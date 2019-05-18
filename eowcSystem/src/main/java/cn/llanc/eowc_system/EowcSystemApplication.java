package cn.llanc.eowc_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.llanc.eowc_system.mapper")
public class EowcSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EowcSystemApplication.class, args);
    }

}
