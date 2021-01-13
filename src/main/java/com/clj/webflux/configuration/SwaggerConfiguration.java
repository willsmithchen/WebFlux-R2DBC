package com.clj.webflux.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author lujia chen
 * @Created 2021/1/12
 * @Description 自定义swagger配置类
 * @date 2021/1/12
 * @Version 1.0.version
 **/
@Data
@ConfigurationProperties(prefix = "spring.swagger")
@EnableSwagger2
@EnableOpenApi
@Configuration
public class SwaggerConfiguration {
    /**
     * 管理组名称
     */
    private String groupName;
    /**
     * swagger主题
     */
    private String title;
    /**
     * swagger描述功能
     */
    private String description;
    /**
     * 参考文档
     */
    private String termsOfServiceUrl;
    /**
     * swagger发行版本
     */
    private String version;

    /**
     * 映射包名
     */
    private String basePackage;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .apiInfo(new ApiInfoBuilder()
                        .title(title)
                        .description(description)
                        .termsOfServiceUrl(termsOfServiceUrl)
                        .version(version)
                        .build()
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }
}
