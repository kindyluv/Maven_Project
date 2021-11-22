package africa.semicolon.beansAppProject.data.repository;

import africa.semicolon.beansAppProject.data.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Customer saveCustomer(Customer customer);
    Customer customerPasswordLength(String password);
    Optional<Customer> findCustomerByEmail(String email);
    List<Customer> findAllCustomers();
    void deleteCustomer(Customer customer);
    void deleteCustomerByEmail(String email);
}
