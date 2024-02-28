package com.pss.controller;

import com.pss.controller.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
@Slf4j
public class EmployeeController {

    Map<Integer, Employee> empMap = Map.of(1, new Employee(1,"John", 32),
                        2, new Employee(2, "William", 42),
                        3, new Employee(3, "George", 52),
                        4, new Employee(4, "David", 35),
                        5, new Employee(5, "Daniel", 41),
                        6, new Employee(6, "Frank", 47));


    @GetMapping("/employee")
    List<Employee> getAllEmployee(){
        return empMap.values().stream().toList();
    }

    @GetMapping("/employee/{id}")
    Employee getEmployee(@PathVariable int id){

        log.info("looking for employee {}", id);
        Employee employee = empMap.get(id);
        log.info("Result {}", employee);
        return employee;
    }

    @PostMapping("/employee/{id}")
    void postEmployee(@RequestBody Employee emp){
        empMap.put(emp.id(), emp);
    }


}
