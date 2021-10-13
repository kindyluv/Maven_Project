package africa.semicolon.BankingApplication.services;

import africa.semicolon.BankingApplication.data.models.Customer;
import africa.semicolon.BankingApplication.data.repositories.CustomerRepository;
import africa.semicolon.BankingApplication.data.repositories.CustomerRepositoryImpl;
import africa.semicolon.BankingApplication.dtos.response.CustomerResponse;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<CustomerResponse> findAll() {
        List<CustomerResponse> responses = new ArrayList<>();
        List<Customer> ourRealCustomers = customerRepository.findAll();
        for (Customer customer : ourRealCustomers) {
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setFirstName(customer.getFirstName());
            customerResponse.setLastName(customer.getLastName());
            customerResponse.setBvn(customer.getBvn());
            customerResponse.setNumberOfAccounts(customer.getAccounts().size());
            responses.add(customerResponse);
        }
        return responses;
    }
}
