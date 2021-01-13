package com.clj.webflux.daos;

import com.clj.webflux.models.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @Author lujia chen
 * @Created 2021/1/12
 * @Description 员工数据查询层
 * @date 2021/1/12
 * @Version 1.0.version
 **/


public interface EmployeeDao extends ReactiveCrudRepository<Employee, Long> {
    /**
     * 根据用户名查询用户信息
     *
     * @param name -用户名称
     * @return
     */
    Flux<Employee> findByName(String name);

}
