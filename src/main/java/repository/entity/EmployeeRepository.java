package repository.entity;

import entity.Employee;
import repository.base.BaseRepository;

import javax.persistence.TypedQuery;

public class EmployeeRepository extends BaseRepository<Employee, Long> {
    private static EmployeeRepository employeeRepository;

    private EmployeeRepository() {

    }

    public static EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) {
            employeeRepository = new EmployeeRepository();
        }
        return employeeRepository;
    }

    public Employee findByUserNamePass(String userName, String pass){
        Employee employee = null;
        try{
            entityManager.getTransaction().begin();
            TypedQuery<Employee> query = entityManager.createQuery(
                    "select e from Employee e where user_name=:uname and password=:pass", Employee.class);
            query.setParameter("uname", userName);
            query.setParameter("pass", pass);
            employee = query.getSingleResult();
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            entityManager.getTransaction().rollback();
            System.out.println(exception.getMessage());
        }
        return employee;
    }

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
