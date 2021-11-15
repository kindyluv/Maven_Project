package africa.semicolon.beansAppProject.controller;

import africa.semicolon.beansAppProject.data.model.Customer;
import africa.semicolon.beansAppProject.dtos.AddCustomerRequest;
import africa.semicolon.beansAppProject.dtos.AddCustomerResponse;
import africa.semicolon.beansAppProject.service.CustomerService;
import africa.semicolon.beansAppProject.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    private final CustomerService customerService = new CustomerServiceImpl();

    @PostMapping("/api/customer")
    public AddCustomerResponse createCustomer(@RequestBody AddCustomerRequest request){
        return customerService.createCustomer(request);
    }

    @GetMapping("/api/customer/{email}")
    public Optional<Customer> findCustomerByEmail(@PathVariable String email){
        return customerService.findCustomerByEmail(email);
    }

    @DeleteMapping("/api/customer/{email}")
    public void deleteCustomerByEmail(@PathVariable String email){
        customerService.deleteCustomerByEmail(email);
    }
}
