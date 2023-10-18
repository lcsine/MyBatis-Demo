package com.ydlclass.mapper;

import com.ydlclass.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> select(Employee employee);
    List<Employee> selectMore();
//    List<Employee> selectById(Integer did);
}
