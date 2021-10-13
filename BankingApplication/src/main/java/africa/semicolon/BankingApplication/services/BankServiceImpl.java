package africa.semicolon.BankingApplication.services;

import africa.semicolon.BankingApplication.data.models.*;
import africa.semicolon.BankingApplication.data.repositories.BankRepository;
import africa.semicolon.BankingApplication.data.repositories.BankRepositoryImp;
import africa.semicolon.BankingApplication.dtos.requests.CreateAccountRequests;

import java.util.List;

public class BankServiceImpl implements BankService{
    private BankRepository bankRepository = new BankRepositoryImp();
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    public String createBank(String bankName) {
        String bankId = generateBankId();
        Bank bank = new Bank(bankId);
        bank.setBankName(bankName);
        Bank savedBank = bankRepository.save(bank);
        return savedBank.getBankId();
    }

    private String generateBankId(){
        int lastBankIdCreated = findAllBanks().size();
        return String.format("%02d", ++lastBankIdCreated);
    }

    @Override
    public List<Bank> findAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public String createAccount(CreateAccountRequests createAccountRequest) {
        String bankId = createAccountRequest.getBankId();
        String accountNumber = generateSuffix(bankId);
        Customer customer = new Customer();
        Account account = new Account();
        account.setAccountNumber(bankId + accountNumber);
        account.setAccountType(createAccountRequest.getAccountType());

        customer.setFirstName(createAccountRequest.getFirstName());
        customer.setLastName(createAccountRequest.getLastName());
        customer.getAccounts().add(account);
        customer.setBvn("No bvn Implementation Yet ");
        customerService.addNew(customer);


        Bank bank = bankRepository.findBankById(bankId);
        bank.getAccounts().add(account);
        bankRepository.save(bank);
        System.out.println(bankRepository.findAll());
        return account.getAccountNumber();
    }

}
