package africa.semicolon.BankingApplication.services;

import africa.semicolon.BankingApplication.data.models.Bank;
import africa.semicolon.BankingApplication.dtos.requests.CreateAccountRequests;

import java.util.Collection;
import java.util.List;

public interface BankService {
    String createBank(String bankName);

    List<Bank> findAllBanks();

    String createAccount(CreateAccountRequests createAccountRequest);
}
