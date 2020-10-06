package repository;

import entity.Customer;

import javax.persistence.TypedQuery;

public class CustomerRepository extends BaseRepository<Customer, Long> {
    private static CustomerRepository customerRepository;

    private CustomerRepository() {

    }

    public static CustomerRepository getCustomerRepository() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepository();
        }
        return customerRepository;
    }

    public Customer findByUserNamePass(String userName,String pass){
        Customer customer = null;
        try{
            entityManager.getTransaction().begin();
            TypedQuery<Customer> query = entityManager.createQuery(
                    "select c from Customer c where user_name=:uname and password=:pass", Customer.class);
            query.setParameter("uname", userName);
            query.setParameter("pass", pass);
            customer = query.getSingleResult();
            entityManager.getTransaction().commit();
        }catch (Exception exception){
            entityManager.getTransaction().rollback();
            System.out.println(exception.getMessage());
        }
        return customer;
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
