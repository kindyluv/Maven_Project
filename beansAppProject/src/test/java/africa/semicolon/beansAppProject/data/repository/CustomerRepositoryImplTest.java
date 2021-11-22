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
        Customer customer__ = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Queen");
        customer.setEmail(customer.getFirstName()+customer.getLastName()+"@gmail.com");
        customer.setPassword("123456");

       customerRepository.saveCustomer(customer);
        assertEquals(1, customerRepository.findAllCustomers().size());
        customer__.setFirstName("John");
        customer__.setLastName("Queen");
//        customer.setEmail(customer.getFirstName()+customer.getLastName()+"@gmail.com");
        customer__.setPassword("12345645");
        customer__.setEmail("John_Queen@gmail.com");
        customerRepository.saveCustomer(customer__);

        assertEquals("John_Queen@gmail.com", customerRepository.findAllCustomers().get(1).getEmail());
    }

    @Test
    void customerPasswordLength() {
        Customer customer = response();

        Customer password = customerRepository.saveCustomer(customer);

        assertEquals(password, customerRepository.customerPasswordLength(response().getPassword()));
    }

    @Test
    void findCustomerByEmail() {
        Customer customer = response();

        customerRepository.saveCustomer(customer);
       assertEquals(1, customerRepository.findAllCustomers().size());
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