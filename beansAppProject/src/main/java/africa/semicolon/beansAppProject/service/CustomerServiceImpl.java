package africa.semicolon.beansAppProject.service;

import africa.semicolon.beansAppProject.data.model.Customer;
import africa.semicolon.beansAppProject.data.repository.CustomerRepository;
import africa.semicolon.beansAppProject.data.repository.CustomerRepositoryImpl;
import africa.semicolon.beansAppProject.dtos.AddCustomerRequest;
import africa.semicolon.beansAppProject.dtos.AddCustomerResponse;
import africa.semicolon.beansAppProject.util.ModelMapper;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public AddCustomerResponse createCustomer(AddCustomerRequest request) {
        Customer customer = ModelMapper.map(request);

        Customer savedCustomer = customerRepository.saveCustomer(customer);

        AddCustomerResponse response = ModelMapper.map(savedCustomer);

        return response;
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public void deleteCustomerByEmail(String email) {

        customerRepository.deleteCustomerByEmail(email);
    }
}
