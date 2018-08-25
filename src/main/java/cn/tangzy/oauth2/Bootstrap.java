package cn.tangzy.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2AutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * @author tangzhiyuan@bitnei.cn
 * @date 8/24/18
 **/
@SpringBootApplication
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Bootstrap.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }
}
