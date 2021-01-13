package com.clj.webflux.controller;

import com.clj.webflux.models.Employee;
import com.clj.webflux.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author: ffzs
 * @Date: 2020/8/10 下午4:43
 */

@Slf4j
@Api(tags = "员工管理")
@RequestMapping("/employee-manager")
@RestController
@RequiredArgsConstructor
@RestControllerAdvice
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    @ApiOperation(value = "查找所有员工信息")
    public Flux<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "根据ID查找员工信息")
    public Mono<Employee> findById(@PathVariable long id) {
        return employeeService.findById(id);
    }

    @GetMapping("find")
    @ApiOperation(value = "根据名称查询员工信息")
    public Flux<Employee> findByName(@RequestParam("name") String name) {
        return employeeService.findByName(name);
    }

    @PostMapping
    @ApiOperation(value = "新增员工信息")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping
    @ApiOperation(value = "修改员工信息")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping
    @ApiOperation(value = "删除员工信息")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@RequestBody Employee employee) {
        return employeeService.delete(employee);
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation(value = "根据ID删除员工信息")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable long id) {
        return employeeService.deleteById(id);
    }
}
