package africa.semicolon.BankingApplication.services;

import africa.semicolon.BankingApplication.data.models.Account;
import africa.semicolon.BankingApplication.data.repositories.CustomerRepository;
import africa.semicolon.BankingApplication.data.repositories.CustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public String createAccount(String firstName, String lastName) {
        return null;
    }

    @Override
    public String createAccount(String firstName, String lastName, String bvn) {
        return null;
    }
}
