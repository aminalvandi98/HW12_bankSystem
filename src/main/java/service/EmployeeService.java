package service;

import entity.BankBranch;
import entity.Employee;
import repository.entity.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        employeeRepository = EmployeeRepository.getEmployeeRepository();
    }

    public Employee checkValidation(String userName, String pass) {
        return employeeRepository.findByUserNamePass(userName, pass);
    }

    public void showAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        for (Employee e : employeeList) {
            System.out.println(e.getId());
            System.out.println(e.getFirstName());
            System.out.println(e.getLastName());
            System.out.println("\t********");
        }
    }

    public Employee getEmployeeByID(Long id) {
        return employeeRepository.findByID(id);
    }

    public void hiringEmployee(Employee employee) {
        if (employeeRepository.insert(employee) != null) {
            System.out.println("The employee was hired successfully.");
            String.format("user name: %s \n password: %s", employee.getUserName(), employee.getPassword());
        }
    }
}
