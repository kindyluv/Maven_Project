package africa.semicolon.BankingApplication.services;

import africa.semicolon.BankingApplication.data.models.Account;
import africa.semicolon.BankingApplication.data.models.Customer;

public interface CustomerService {

    Account createAccount(String firstName, String lastName);

    Account createAccount(String firstName, String lastName, String bvn);
}
