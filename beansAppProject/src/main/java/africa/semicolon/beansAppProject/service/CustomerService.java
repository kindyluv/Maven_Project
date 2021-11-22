package africa.semicolon.beansAppProject.service;

import africa.semicolon.beansAppProject.data.model.Customer;
import africa.semicolon.beansAppProject.dtos.AddCustomerRequest;
import africa.semicolon.beansAppProject.dtos.AddCustomerResponse;

import java.util.Optional;

public interface CustomerService {

    AddCustomerResponse createCustomer(AddCustomerRequest request);
    Optional<Customer> findCustomerByEmail(String email);
    void deleteCustomerByEmail(String email);
}
