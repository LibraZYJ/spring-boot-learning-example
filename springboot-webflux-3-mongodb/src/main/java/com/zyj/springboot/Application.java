package com.zyj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yujie_Zhao
 * @ClassName Application
 * @Description TODO
 * @Date 2021/4/16  14:47
 * @Version 1.0
 **/
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class,args);

    }
}