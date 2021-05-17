package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Employee;
import com.packt.webstore.repository.EmployeeRepository;
import com.packt.webstore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
    public List<Employee> findAll() {
        return (List<Employee>)employeeRepository.findAll();
    }
    public Employee findByEmployeeId(Long id) {
        return employeeRepository.locateOneEmployeeByHisNumber(id);
    }
}