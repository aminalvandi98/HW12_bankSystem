package service;

import entity.Customer;
import repository.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = CustomerRepository.getCustomerRepository();
    }

    public Customer checkValidation(String userName, String pass) {
        return customerRepository.findByUserNamePass(userName,pass);
    }
}
