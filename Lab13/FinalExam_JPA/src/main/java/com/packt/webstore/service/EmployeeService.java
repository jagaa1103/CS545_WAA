package com.packt.webstore.service;

import com.packt.webstore.domain.Employee;

import java.util.List;

public interface EmployeeService {
    public void save(Employee employee);
    public List<Employee> findAll();
    public Employee findByEmployeeId(Long id);
}
