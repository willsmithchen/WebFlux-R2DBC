package com.clj.webflux.services;

import com.clj.webflux.models.Employee;
import com.clj.webflux.daos.EmployeeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author lujia chen
 * @Created 2021/1/12
 * @Description 员工服务类接口
 * @date 2021/1/12
 * @Version 1.0.version
 **/

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    /**
     * 查询所有员工信息
     *
     * @return 所有用户信息
     */
    public Flux<Employee> findAll() {
        return employeeDao.findAll();
    }

    /**
     * 根据id查询员工信息
     *
     * @param id -员工id
     * @return
     */
    public Mono<Employee> findById(long id) {
        return employeeDao.findById(id);
    }

    /**
     * 根据name查询员工信息
     *
     * @param name -员工名称
     * @return
     */
    public Flux<Employee> findByName(String name) {
        return employeeDao.findByName(name);
    }

    /**
     * 保存员工信息
     *
     * @param employee -要保存的员工信息参数
     * @return
     */
    public Mono<Employee> save(Employee employee) {
        return employeeDao.save(employee);
    }

    /**
     * 修改员工信息
     *
     * @param employee
     * @return
     */
    public Mono<Void> update(Employee employee) {
        return findById(employee.getId())
                .map(em -> employee.withId(em.getId()))
                .flatMap(employeeDao::save)
                .then();
    }

    /**
     * 删除员工信息
     *
     * @param employee
     * @return
     */
    public Mono<Void> delete(Employee employee) {
        return employeeDao.delete(employee);
    }

    /**
     * 根据员工ID信息进行删除
     *
     * @param id -员工ID
     * @return
     */
    public Mono<Void> deleteById(long id) {
        return employeeDao.deleteById(id);
    }
}
