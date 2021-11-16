package africa.semicolon.beansAppProject.data.repository;

import africa.semicolon.beansAppProject.data.model.Customer;
import africa.semicolon.beansAppProject.exception.EmailNotFoundException;

import java.util.*;

public class CustomerRepositoryImpl implements CustomerRepository{
    private Map<String, Customer> database = new HashMap<>();

    @Override
    public Customer saveCustomer(Customer customer) {
        String email = "";
        if(customer.getEmail() == null){
            email = customer.getFirstName() + customer.getLastName() + "@gmail.com";
            customer.setEmail(email);
        }
        email = customer.getEmail();
        database.put(email, customer);
        return database.get(email);
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String email) {
        if(!(database.containsKey(email))) throw new EmailNotFoundException("please enter a valid email");
            return Optional.of(database.get(email));
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        Set<String> keys = database.keySet();
        for(String key: keys){
            customers.add(database.get(key));
        }
        return customers;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        database.remove(customer.getEmail());
    }

    @Override
    public void deleteCustomerByEmail(String email) {
        database.remove(email);
    }

}
