package com.hydu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created on 2019/10/11
 * @author heyong
 */
@SpringBootApplication
@EnableDiscoveryClient
/**
 * mapper上没有加@Mapper注解，需要在这加上@MapperScan注解
 */
@MapperScan("com.hydu.mapper")
public class ItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class,args);
    }
}