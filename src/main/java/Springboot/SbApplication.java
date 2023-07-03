package Springboot;

import Springboot.test.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SbApplication {
    public static void main(String[] args) {
        /*
        ConfigurableApplicationContext是ApplicationContext的子接口提供了更多功能例：许在应用程序上下文启动后进行配置修改，例如注册和销毁Bean，添加和移除监听器等。
        ApplicationContext接口在应用程序上下文启动后通常是只读的，不允许进行配置修改。
        */
        ConfigurableApplicationContext context = SpringApplication.run(SbApplication.class);
        context.getBean(User.class);
    }
}
