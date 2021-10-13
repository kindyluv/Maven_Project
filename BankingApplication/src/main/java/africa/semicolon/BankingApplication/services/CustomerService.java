package africa.semicolon.BankingApplication.services;

import africa.semicolon.BankingApplication.data.models.Account;
import africa.semicolon.BankingApplication.data.models.Customer;
import africa.semicolon.BankingApplication.dtos.response.CustomerResponse;

import java.util.Collection;
import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAll();
}
