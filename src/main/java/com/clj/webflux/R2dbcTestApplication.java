package com.clj.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @Author lujia chen
 * @Created 2021/1/12
 * @Description r2dbc启动类
 * @date 2021/1/12
 * @Version 1.0.version
 **/
@SpringBootApplication
public class R2dbcTestApplication implements WebFluxConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(R2dbcTestApplication.class, args);
    }
}
