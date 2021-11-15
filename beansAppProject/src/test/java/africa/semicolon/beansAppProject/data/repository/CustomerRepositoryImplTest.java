package africa.semicolon.beansAppProject.data.repository;

import africa.semicolon.beansAppProject.data.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryImplTest {
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepositoryImpl();
    }

    public Customer response(){
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Queen");
        customer.setEmail(customer.getFirstName()+customer.getLastName()+"@gmail.com");
        customer.setPassword("123456");
        return customer;
    }

    @Test
    void saveCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Queen");
        customer.setEmail(customer.getFirstName()+customer.getLastName()+"@gmail.com");
        customer.setPassword("123456");

       customerRepository.saveCustomer(customer);
        assertEquals(1, customerRepository.findAllCustomers().size());
    }

    @Test
    void findCustomerByEmail() {
        Customer customer = response();

        customerRepository.saveCustomer(customer);
       customerRepository.findCustomerByEmail(customer.getEmail());
        assertEquals("JohnQueen@gmail.com", customerRepository.findAllCustomers().get(0).getEmail());
    }

    @Test
    void findAllCustomers() {
        Customer customer = response();

        customerRepository.saveCustomer(customer);
        assertEquals(1, customerRepository.findAllCustomers().size());
    }

    @Test
    void deleteCustomer() {
        Customer customer = response();

        customerRepository.saveCustomer(customer);
        customerRepository.deleteCustomer(customer);
        assertEquals(0, customerRepository.findAllCustomers().size());
    }

    @Test
    void deleteCustomerByEmail() {
        Customer customer = response();

        customerRepository.saveCustomer(customer);
        customerRepository.deleteCustomerByEmail(response().getEmail());
        assertEquals(0, customerRepository.findAllCustomers().size());
    }
}