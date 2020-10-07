package service;

import entity.Employee;
import repository.entity.EmployeeRepository;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        employeeRepository = EmployeeRepository.getEmployeeRepository();
    }

    public Employee checkValidation(String userName, String pass) {
        return employeeRepository.findByUserNamePass(userName,pass);
    }
}
