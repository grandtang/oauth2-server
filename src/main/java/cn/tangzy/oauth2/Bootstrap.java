package cn.tangzy.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

/**
 * @author tangzhiyuan@bitnei.cn
 * @date 8/24/18
 **/
@SpringBootApplication
@MapperScan("cn.tangzy.oauth2")
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Bootstrap.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }

}
