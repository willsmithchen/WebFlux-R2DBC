package com.clj.webflux.models;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author lujia chen
 * @Created 2021/1/12
 * @Description 员工实体类信息
 * @date 2021/1/12
 * @Version 1.0.version
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("employee")
@ApiModel(value = "员工类")
public class Employee {
    @Id
    @ApiModelProperty(value = "员工序号", position = 1)
    private long id;
    @ApiModelProperty(value = "员工姓名", position = 2)
    private String name;
    @ApiModelProperty(value = "员工年龄", position = 3)
    private long age;
    @ApiModelProperty(value = "员工薪资", position = 4)
    private long salary;
}
