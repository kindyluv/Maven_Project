package africa.semicolon.beansAppProject.util;

import africa.semicolon.beansAppProject.data.model.Customer;
import africa.semicolon.beansAppProject.dtos.AddCustomerRequest;
import africa.semicolon.beansAppProject.dtos.AddCustomerResponse;

public class ModelMapper {

    public static Customer map(AddCustomerRequest request){
        Customer customer = new Customer();

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPassword(request.getPassword());
        return customer;
    }

    public static AddCustomerResponse map(Customer savedCustomer){
        AddCustomerResponse response = new AddCustomerResponse();

        response.setFirstName(savedCustomer.getFirstName());
        response.setLastName(savedCustomer.getLastName());
        response.setEmail(savedCustomer.getEmail());
        response.setPassword(savedCustomer.getPassword());

        return response;

    }
}
