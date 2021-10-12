package africa.semicolon.BankingApplication.data.repositories;

import africa.semicolon.BankingApplication.data.models.Bvn;
import africa.semicolon.BankingApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryImplTest {
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("123456", customer);

        customer.setBvn(bvn.getId());
        customer.setFirstName("Ojo");
        customer.setLastName("Lawal");

        Customer savedCustomer = customerRepository.save(customer);
        assertEquals(customer, savedCustomer);
    }

    @Test
    void findById() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("123456", customer);

        customer.setBvn(bvn.getId());
        customer.setFirstName("Ojo");
        customer.setLastName("Lawal");
        customerRepository.save(customer);

        Customer foundCustomer = customerRepository.findById("123456");
        assertEquals(customer, foundCustomer);
    }

    @Test
    void delete() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("123456", customer);

        customer.setBvn(bvn.getId());
        customer.setFirstName("Ojo");
        customer.setLastName("Lawal");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findById("123456"));

        customerRepository.delete(customer);

        assertNull(customerRepository.findById("123456"));
    }

    @Test
    void testDelete() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("123456", customer);

        customer.setBvn(bvn.getId());
        customer.setFirstName("Ojo");
        customer.setLastName("Lawal");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findById("123456"));

        customerRepository.delete("123456");

        assertNull(customerRepository.findById("123456"));
    }

    @Test
    void findAll() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("123456", customer);

        customer.setBvn(bvn.getId());
        customer.setFirstName("Ojo");
        customer.setLastName("Lawal");
        customerRepository.save(customer);
        customerRepository.save(customer);
        customerRepository.save(customer);

        assertEquals(3, customerRepository.findAll().size());

    }
}