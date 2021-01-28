package com.balsampears.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
@EnableSwagger2
//@EnableTransactionManagement
//@EnableScheduling
//@EnableCaching
//@EnableAsync
public class SpringbootDemoApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext env = SpringApplication.run(SpringbootDemoApplication.class, args);
        String ip = InetAddress.getLocalHost().getHostAddress();
        Environment em = env.getEnvironment();
        String port = em.getProperty("server.port");
        String path = em.getProperty("server.servlet.context-path") == null ? "" : em.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "swagger-ui: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n\t"
        );

    }

}
