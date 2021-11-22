package africa.semicolon.beansAppProject.controller;

import africa.semicolon.beansAppProject.data.model.Customer;
import africa.semicolon.beansAppProject.dtos.AddCustomerRequest;
import africa.semicolon.beansAppProject.dtos.AddCustomerResponse;
import africa.semicolon.beansAppProject.exception.*;
import africa.semicolon.beansAppProject.service.CustomerService;
import africa.semicolon.beansAppProject.service.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    private final CustomerService customerService = new CustomerServiceImpl();

    @CrossOrigin(origins = "http://localhost:3001/")
    @PostMapping("/api/customer")
    public ResponseEntity<?> registerAccount(@RequestBody AddCustomerRequest request){
        try{
            AddCustomerResponse response = customerService.createCustomer(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(DuplicateCustomerException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://localhost:3001/")
    @GetMapping("/api/customer/{email}")
    public ResponseEntity<?> login(@PathVariable String email){
        try{
            Optional<Customer> loginRequest = customerService.findCustomerByEmail(email);
            return new ResponseEntity<>(loginRequest, HttpStatus.FOUND);
        }catch(EmailNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @CrossOrigin(origins = "http://localhost:3001/")
    @DeleteMapping("/api/customer/{email}")
    public void deleteAccountByEmail(@PathVariable String email){
        customerService.deleteCustomerByEmail(email);
    }
}
